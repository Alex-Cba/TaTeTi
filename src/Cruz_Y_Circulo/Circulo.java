package Cruz_Y_Circulo;

import TodosSprites.All_Sprites;

import javax.swing.*;

public class Circulo
{
    private ImageIcon spr_circulo;
    private static All_Sprites _All_Sprite = All_Sprites.getInstance();

    public ImageIcon getSpr_circulo() {
        return spr_circulo;
    }

    public Circulo(){
        spr_circulo = _All_Sprite.getImg_circulo();
    }
}
