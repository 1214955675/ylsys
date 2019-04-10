package com.bs.sys.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author wwj
 * 2019/4/10 18:12
 */
public interface UploadService {
    boolean upLoadEditorImg(List<MultipartFile> list,String UploadAbsolutePath,
                            String UploadRelativePath);

}
