package com.leyou.upload.service;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author fenghu
 * @description: TODO
 * @date 2019/7/39:27
 */
@Service
@Slf4j
public class UploadService {
    private static final List<String> suffixes= Arrays.asList("image/png","image/jpeg");
    public String uploadImage(MultipartFile file) {

        try {
            //图片信息校验
            String type = file.getContentType();
            if(!suffixes.contains(type)){
                log.info("图片类型不匹配");
                return null;
            }
            //校验图片内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if(image==null){
                log.info("图片为空");
                return null;
            }

            File dir = new File("D:\\黑马\\upload");
            if(!dir.exists()){
                dir.mkdir();
            }
            //保存图片
            file.transferTo(new File(dir,file.getOriginalFilename()));
            log.info("图片名字：{}",file.getName());
            log.info("图片名字：{}",file.getOriginalFilename());
            String url="http://image.leyou.com/upload/"+file.getOriginalFilename();
            return url;
        } catch (Exception e) {
            throw new LyException(ExceptionEnum.UPLOADIMAGE_ERROR);
        }
    }
}
