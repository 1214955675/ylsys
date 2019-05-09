package com.bs.sys.service;

import com.bs.sys.entity.ImgResultDto;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

/**
 * @author wwj
 * 2019/4/10 18:12
 */
public interface UploadService {
    ImgResultDto upLoadEditorImg(List<MultipartFile> list, String UploadAbsolutePath,
                                 String UploadRelativePath) throws IOException;

}
