package Cruz_Y_Circulo;

import TodosSprites.All_Sprites;

import javax.swing.*;

public class Cruz
{
    private ImageIcon spr_cruz;
    private static All_Sprites _All_Sprites = All_Sprites.getInstance();

    public ImageIcon getSpr_cruz() {
        return spr_cruz;
    }

    public Cruz(){
        spr_cruz = _All_Sprites.getImg_cruz();
    }
}
