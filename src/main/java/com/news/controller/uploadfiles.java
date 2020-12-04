package com.news.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.news.entity.Source;
import com.news.service.SourceService;
import com.news.util.FileUploadUtils;
import com.news.util.UploadFile;

@Controller
public class uploadfiles {
	@Autowired
	SourceService sourceService;
	
	
	@RequestMapping("uploadfiles")
	public String test1(HttpServletRequest request) throws Exception{
		MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) request;
		List<MultipartFile> files = mrequest.getFiles("duofile");//ͨ����ȡҳ�����ļ����name����,�õ���Ӧ���ļ����� ,װ�س�һ��List����
		//�����Լ�д���ļ��ϴ������� FileUploadUtils ��upLoadFile����ʵ�ֶ��ļ��ϴ�����������ĳ��·����
//		upLoadFile   param1  request���� ,Ϊ�˻�ȡ����url·����ĳЩ��Ϣ
//					param2   �ϴ��Ķ���ļ�����
//			 		param3  �ϴ���·��
		Map<String, UploadFile> upLoadFile = FileUploadUtils.upLoadFile(request,files , "newsimg");
		System.out.println(upLoadFile);
		for(Map.Entry<String, UploadFile> imgs :upLoadFile.entrySet()){
			System.out.println(imgs.getKey());
			System.out.println(imgs.getValue().getFileSize());
			System.out.println(imgs.getValue().getFileType());
			System.out.println(imgs.getValue().getNewFileName());
			System.out.println(imgs.getValue().getNewFilePath());
			System.out.println(imgs.getValue().getNewFileUrl());
			String url=imgs.getValue().getNewFileUrl();
			Source source=new Source();
			source.setSrc(url);
            if (imgs.getValue().getFileType().equals("video/mp4"))
                source.setType(2);
            else if (imgs.getValue().getFileType().equals("image/jpeg"))
                source.setType(1);
            else source.setType(3);
//			source.setType(1);
			source.setNid(Integer.parseInt(request.getParameter("nid")));
			int i=sourceService.insert(source);
			System.out.println("============"+i);
			//request.setAttribute("url", url);
			request.getSession().setAttribute("url", url);
			System.out.println(imgs.getValue().getOriginalFileName());
		}
		return "redirect:houtai/file.jsp";
	}

	@RequestMapping("uploadmovie")
	public String test2(HttpServletRequest request) throws Exception{
		MultipartHttpServletRequest mrequest = (MultipartHttpServletRequest) request;
		List<MultipartFile> files = mrequest.getFiles("duofile");//ͨ����ȡҳ�����ļ����name����,�õ���Ӧ���ļ����� ,װ�س�һ��List����
		//�����Լ�д���ļ��ϴ������� FileUploadUtils ��upLoadFile����ʵ�ֶ��ļ��ϴ�����������ĳ��·����
//		upLoadFile   param1  request���� ,Ϊ�˻�ȡ����url·����ĳЩ��Ϣ
//					param2   �ϴ��Ķ���ļ�����
//			 		param3  �ϴ���·��
		Map<String, UploadFile> upLoadFile = FileUploadUtils.upLoadFile(request,files , "newsimg");
		System.out.println(upLoadFile);
		for(Map.Entry<String, UploadFile> imgs :upLoadFile.entrySet()){
			System.out.println(imgs.getKey());
			System.out.println(imgs.getValue().getFileSize());
			System.out.println(imgs.getValue().getFileType());
			System.out.println(imgs.getValue().getNewFileName());
			System.out.println(imgs.getValue().getNewFilePath());
			System.out.println(imgs.getValue().getNewFileUrl());
			String url=imgs.getValue().getNewFileUrl();
			Source source=new Source();
			source.setSrc(url);
			source.setType(2);
			source.setNid(Integer.parseInt(request.getParameter("nid")));
			int i=sourceService.insert(source);
			System.out.println("============"+i);
			//request.setAttribute("url", url);
			request.getSession().setAttribute("url", url);
			System.out.println(imgs.getValue().getOriginalFileName());
		}
		return "redirect:houtai/file.jsp";
	}
}
