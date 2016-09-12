package verifycode;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

/**
 * Created by Mayijun on 2016/9/8.
 */
public class VerifyCode {
    // 验证码图片的宽度。
    private int width = 60;
    // 验证码图片的高度。
    private int height = 30;
    //没有O,I,0,1，怕弄混,一共32个
    char[] codeArray = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J',
            'K', 'L', 'M', 'N',  'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
            'X', 'Y', 'Z' , '2', '3', '4', '5', '6', '7', '8', '9' };

    private String codeString;

    //存放图片的地址
    private String jpgPath="C:\\ZZJava\\MyBBS\\VerifyCode\\";

    //随机合成一个由4个字母组成的字符串
    public String randomCode(){
        Random random=new Random();
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<4;i++){
            stringBuilder.append(codeArray[random.nextInt(32)]+" ");
        }
        return stringBuilder.toString();
    }

    //codePath不用写.jpg
    public BufferedImage getVerifyCode(String codePath) throws IOException {
        codeString=randomCode();
        BufferedImage bufferedImage=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D=(Graphics2D) bufferedImage.getGraphics();
        graphics2D.setColor(Color.WHITE);
        graphics2D.fillRect(0,0,width,height);
        graphics2D.setColor(Color.BLACK);
        graphics2D.drawString(codeString,10,height-10);
        ImageIO.write(bufferedImage,"JPEG",new FileOutputStream(jpgPath+codePath+".jpg"));
        return bufferedImage;
    }
    //获得字符串
    public String getCodeString(){
        char[] codeChar=codeString.toCharArray();
        StringBuilder newCodeString=new StringBuilder();
        for(int i=0;i<codeChar.length;i++){
            if(codeChar[i]!=' '){
                newCodeString.append(codeChar[i]);
            }
        }
        return newCodeString.toString();
    }
    //输出验证码图片
    public static void output(BufferedImage bufferedImage, OutputStream outputStream) throws IOException {
        ImageIO.write(bufferedImage,"JPEG",outputStream);
    }
}
