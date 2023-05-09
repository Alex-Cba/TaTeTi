package TodosSprites;

import javax.swing.*;
import java.io.File;

public class All_Sprites
{
    private static All_Sprites Instance = null;
    private File file_cruz = new File("src/Sprites/Cruz.png");
    private File file_circulo = new File("src/Sprites/Circulo.png");

    private ImageIcon img_cruz;
    private ImageIcon img_circulo;

    public File getFile_cruz() {
        return file_cruz;
    }

    public File getFile_circulo() {
        return file_circulo;
    }

    public ImageIcon getImg_cruz() {
        return img_cruz;
    }

    public ImageIcon getImg_circulo() {
        return img_circulo;
    }

    private All_Sprites(){
        img_cruz = new ImageIcon(file_cruz.getAbsolutePath());
        img_circulo = new ImageIcon(file_circulo.getAbsolutePath());
    }

    public static All_Sprites getInstance() {
        if(Instance == null){
            Instance = new All_Sprites();
        }
        return Instance;
    }
}
