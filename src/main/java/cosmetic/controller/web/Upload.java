package cosmetic.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class Upload {

    private static final String UPLOAD_DIR = File.separator + "upload" + File.separator;

    @GetMapping("/uploadpath")
    public String upload() {
        return "web/Upload";
    }

    @PostMapping("/uploadpath")
    @ResponseBody
    public String upload2(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        String rootPath = request.getServletContext().getRealPath("") + UPLOAD_DIR;
        String fileName = file.getOriginalFilename();
        File descFile = new File(rootPath + fileName);

        if (!descFile.getParentFile().exists()) {
            descFile.getParentFile().mkdirs();
        }

        try {
            file.transferTo(descFile);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String urlImg = (UPLOAD_DIR + fileName).replaceAll("\\\\", "/");
        return urlImg;
    }
}
