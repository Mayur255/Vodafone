package com.vodafone.home.page;

import java.io.File;

public class link_test1 {

		String link_test1(String Image_extension) {
		
			
	    if(Image_extension.lastIndexOf(".") != -1 && Image_extension.lastIndexOf(".") != 0)
	    return Image_extension.substring(Image_extension.lastIndexOf(".")+1);
	    else return "";
	    
	    
	    
	    
	}
		
		
}