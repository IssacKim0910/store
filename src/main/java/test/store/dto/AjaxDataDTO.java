package test.store.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AjaxDataDTO {
	private boolean success = false;
	private String message;
	private Object data;
	private long total;
//	private List<Object> list = new ArrayList<Object>();
	private List<? extends Object> list = new ArrayList<>();	
	private long page;
	private long size;
	private long totalPages;
	
}
