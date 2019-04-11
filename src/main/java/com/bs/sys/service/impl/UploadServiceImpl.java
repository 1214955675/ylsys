package com.bs.sys.service.impl;

import com.bs.sys.entity.ImgResultDto;
import com.bs.sys.service.UploadService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * Created by Windows10 on 2019/4/11/0011.
 */
@Service
public class UploadServiceImpl implements UploadService{
    public ImgResultDto upLoadEditorImg(List<MultipartFile> list, String UploadAbsolutePath, String UploadRelativePath) throws IOException {
        return null;
    }
}
