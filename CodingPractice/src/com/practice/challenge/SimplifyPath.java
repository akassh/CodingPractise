package com.practice.challenge;

public class SimplifyPath {
	public static String simplifyPath(String path) {
		String sb = "";
		String[] s = path.split("/");
		for(int i=0;i<s.length;++i)
			if(!s[i].isEmpty())
				switch(s[i]) {
					case ".."   :       sb =  sb.lastIndexOf("/")==-1 ? "" : sb.substring(0,sb.lastIndexOf("/"));
										break;
					case "."    :  
					case ""     :		break;
					default     :		sb = sb + "/" + s[i];
				}  
		return sb.isEmpty() ? "/" : sb;
	}
    
	public static void main(String[] args) {
		System.out.println(simplifyPath("/a/./b///../c/../././../d/..//../e/./f/./g/././//.//h///././/..///"));
	}
}
