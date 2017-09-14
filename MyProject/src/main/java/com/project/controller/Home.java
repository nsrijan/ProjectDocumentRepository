package com.project.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.User;
import com.project.model.UserProject;
import com.project.service.UserProjectService;
import com.project.service.UserService;


@Controller
@SessionAttributes({"email"})
public class Home {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserProjectService userProjectService;
	 
	String email;
	
	@RequestMapping(value="index")
	public ModelAndView requestIndex( HttpSession session ){
		
		User validUser = (User)session.getAttribute("validUser");
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("validUser", validUser);
		if(validUser != null) {
		email = validUser.getUserFirstName();
		mv.addObject("email", email);
		}
		System.out.println("Before Foing to index === >>>"+validUser);
		return mv;
	}
	
	@RequestMapping(value="home")
	public String requestHome(){
		return "home";
	}
	
	@RequestMapping(value="login")
	public String requestLogin(){
		return "login";
	}
	@RequestMapping(value="signup")
	public String requestSignup(){
		return "signup";
	}

	
	@RequestMapping(value="logout")
	public String logout(HttpSession session){
		session.removeAttribute("validUser");
		return "login";
	}
	
	@RequestMapping(value="add-user")
	public ModelAndView addUser(@ModelAttribute User user){
		System.out.println("Add USER ==== >>>>>"+user);
		userService.addUser(user);
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
	
	
	@RequestMapping(value = "upload-project", method = RequestMethod.POST)
	public ModelAndView uploadUserProject(@ModelAttribute UserProject userProject, BindingResult bindingResult,
			@RequestParam(value = "userProjectFile", required = true) MultipartFile userProjectFile,
			HttpServletRequest request) {
		
		System.out.println("file name===>>>>>>" + userProjectFile.getOriginalFilename());
		String ext = FilenameUtils.getExtension(userProjectFile.getOriginalFilename());
		
		if ( !ext.equals("pdf") ) {
			return new ModelAndView("upload", "errorMsg", "Please upload pdf file");
		}
		
		else {
			
/*			String path=request.getRealPath("/resources/img/products");
			String filename = new SimpleDateFormat("yyyyMMddHHmm").format(new Date());
			System.out.println(path+"=========>>>>>> "+filename);        

			byte[] bytes = pimages.getBytes();  
			BufferedOutputStream stream =new BufferedOutputStream(new FileOutputStream(  
					new File(path + File.separator + filename)));  
			System.out.println(path +"=========>>>>>> "+ File.separator +"=========>>>>>> "+ filename);        

			stream.write(bytes);  
			stream.flush();  
			stream.close();  

			product.setPimages(filename);*/
			
			
			
			userProject.setUserProjectFile(userProject.getUserProjectTitle() + ".pdf");
			String rootDirectory = request.getSession().getServletContext().getRealPath("/resources/documents");
			System.out.println("root Directory --->>>" + rootDirectory);
			
			File reportLocation = new File(request.getSession().getServletContext()
					.getRealPath("/document/" + userProject.getUserProjectFile() + "/"));
			System.out.println("report location: --->>>>" + reportLocation);
			userProject.setReportLocate(reportLocation.toString());
	
			try {
				FileUtils.writeByteArrayToFile(reportLocation, userProjectFile.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}

			userProjectService.addUserProject(userProject);
			List<UserProject> userProjectList = userProjectService.getUserProjectList();
			
			for (UserProject up : userProjectList){
				System.out.println("user Project:===????" + up.getUserProjectTitle());
			}
			
			ModelAndView mv = new ModelAndView("project-list");
			mv.addObject("projectList", userProjectList);
			return mv;
		}
		
	}

	@RequestMapping(value="viewUserProject")
	public ModelAndView viewUserProject(@RequestParam("userProjectId") int userProjectId){
		
		UserProject userProject = userProjectService.viewUserProjectById(userProjectId);
		ModelAndView mv = new ModelAndView("displayProject");
		mv.addObject("userProject", userProject);
		return mv;
	}
	
	
}
