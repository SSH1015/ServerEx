package com.spring.board;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.spring.domain.cataractVO;
import com.spring.service.Pager;
import com.spring.service.cataractService;

@Controller
@RequestMapping("/cataract/*")
public class CataractController {
	
	
	@Inject
	private cataractService cataractService;
	
	// 백내장 관리
	@RequestMapping(value="list", method = RequestMethod.GET)
	public ModelAndView cataractList(@RequestParam(defaultValue = "c_name") String searchOption,
	        @RequestParam(defaultValue = "") String keyword,
	        @RequestParam(defaultValue = "1") int curPage,
	        @RequestParam(value = "cata", required = false) String cata) throws Exception {
		
	    // 레코드의 갯수 계산	  
	    int count = cataractService.countArticle(searchOption, keyword);

	    // 페이지 나누기 관련 처리
	    Pager cataractPager = new Pager(count, curPage);
	    int start = cataractPager.getPageBegin() - 1;
	    int end = cataractPager.getPageEnd();
	    
	    List<cataractVO> list = cataractService.listAll(start, end, searchOption, keyword);
	    
	    ModelAndView mav = new ModelAndView();
	    
	    Map<String, Object> map = new HashMap<String, Object>();
	    mav.addObject("list", list); 
	    mav.addObject("count", count); 
	    mav.addObject("searchOption", searchOption);
	    mav.addObject("keyword", keyword);
	    mav.addObject("cataractPager", cataractPager);
	    mav.addObject("cata", cata);
	    //System.out.println("ddddd");	  
	    mav.addObject("map", map);
	    mav.setViewName("cataract/cataract_list");
	    return mav;
	}

	
	// 백내장 정보 등록
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String cataractInsertView() {
		return "cataract/cataract_insert";
	}
	
	//@RequestMapping(value = "/asdf", method = RequestMethod.POST)
	//public String cataractInsert(@ModelAttribute cataractVO vo) {
		//System.out.println("백내장 게시물 등록");
		//cataractService.insertCt(vo);
		
		//return "redirect:/cataract/list";
	//}
	
	@RequestMapping("/view")
	public String cataractView(Model model, int c_num) {
		System.out.println("백내장 상세보기");
		
		model.addAttribute("dto", cataractService.viewCt(c_num)); //session영역에 저장
		return "cataract/cataract_view";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String cataractDelete(@ModelAttribute cataractVO vo, Model model) {
		//String cataractId = vo.getC_id();
		//cataractService.deleteCt(cataractId);
		return "redirect:/cataract/list";
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String cataractUpdate(@ModelAttribute cataractVO vo) {
		cataractService.updateCt(vo);
		
		return "redirect:/cataract/list";
	}
	
	@Value("http://43.201.34.101:5000/detect")
    private String flaskServerUrl; // Replace with your Flask server URL
	
	/* 첨부파일 업로드 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String fileUpload(@RequestParam("file") MultipartFile file, Model model, @ModelAttribute cataractVO vo, HttpServletRequest request) {
		RestTemplate restTemplate = new RestTemplate();
        try {
            // Encode the image file in base64 format
            String base64Image = encodeImage(file);

            // Create the request body
            MultiValueMap<String, Object> requestBody = new LinkedMultiValueMap<String, Object>();
            requestBody.add("img_path", file.getOriginalFilename());
            requestBody.add("data", base64Image);
            requestBody.add("uuid", generateUUID());

            // Create the request headers
            org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            // Create the HTTP entity with headers and body
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<MultiValueMap<String, Object>>(requestBody, headers);

            // Send the POST request to the Flask server
            ResponseEntity<String> response = restTemplate.postForEntity(flaskServerUrl, requestEntity, String.class);

            // Handle the response if needed
            // ...
            
            String cata = response.getBody();
            System.out.println(cata);
            model.addAttribute("cata", cata);
            
        
        } catch (Exception e) {
        	String cata = "3";
        	model.addAttribute("cata", cata);
        	 return "redirect:/cataract/list";
        }

        
      
        
        
		
		String fileRealName = file.getOriginalFilename(); //파일명을 얻어낼 수 있는 메서드!

		long size = file.getSize(); //파일 사이즈
		
		System.out.println("파일명 : "+fileRealName);
		System.out.println("용량크기(byte) : "+size);
		String akey = "AKIAYAHX5WNPNU6XVUJA";
		String pkey = "ojUKT1nGNxT0f6JfOTuw3zIHX3aKgSsfeo3Q0TpU";
		
		 AWSCredentials credentials = new BasicAWSCredentials(akey, pkey);
	        System.out.println(akey + "\n" +pkey);
	        // Create an S3 client with default credential provider chain
	        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
	        		.withCredentials(new AWSStaticCredentialsProvider(credentials))
	        		.withRegion(Regions.AP_NORTHEAST_2)
	        		.build();

	        // Specify the bucket name and key (file path) for the image in the S3 bucket
	        String bucketName = "eyetext";
	        String key = "images/" + fileRealName;

	        try {
	        	 InputStream inputStream = file.getInputStream();
	            // Upload the image file to the S3 bucket
	            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, inputStream, new ObjectMetadata());
	            s3Client.putObject(putObjectRequest);

	            // Set the image URL to the S3 bucket URL for accessing the uploaded image
	            String imageUrl = key;
	            vo.setC_img(imageUrl);
	        } catch (Exception e) {
	            e.printStackTrace();
	            // Handle exception
	        }


		cataractService.insertCt(vo);
		
		return "redirect:/cataract/list";
	}
    private String encodeImage(MultipartFile image) throws IOException {
        byte[] imageBytes = image.getBytes();
        return java.util.Base64.getEncoder().encodeToString(imageBytes);
    }
    private String generateUUID() {
        // Implement your UUID generation logic here
        // ...
    	UUID uuid = UUID.randomUUID();
    			
        return uuid.toString();
    }
	 

}

