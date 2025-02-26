package graphite.mod.impl;
 
import graphite.gui.hud.ScreenPosition;
import graphite.mod.Category;
import graphite.mod.DragableMod;
import net.minecraft.client.gui.Gui;
 
import java.awt.*;
 
public class ModCoordinates extends ModDragable {
 
    private ScreenPosition position;
    private Color background = new Color(45, 45, 45, 180);
 
    @Override
    public void save(ScreenPosition pos) {
        this.position = pos;
    }
 
    @Override
    public ScreenPosition load() {
        return position;
    }
 
    @Override
    public int getWidth() {
        return this.font.getStringWidth("X: 00000");
    }
 
    @Override
    public int getHeight() {
        return this.font.FONT_HEIGHT * 3 + 2;
    }
 
    @Override
    public void render(ScreenPosition pos) {
        int width = this.font.getStringWidth("X: 00000");
        if(this.mc.getRenderViewEntity().posX >= this.mc.getRenderViewEntity().posY && this.mc.getRenderViewEntity().posX >= this.mc.getRenderViewEntity().posZ) {
            width = this.font.getStringWidth("X: " + (int) this.mc.getRenderViewEntity().posX);
 
        } else if(this.mc.getRenderViewEntity().posY >= this.mc.getRenderViewEntity().posX && this.mc.getRenderViewEntity().posY >= this.mc.getRenderViewEntity().posZ) {
            width = this.font.getStringWidth("Y: " + (int) this.mc.getRenderViewEntity().posY);
 
        } else if(this.mc.getRenderViewEntity().posZ >= this.mc.getRenderViewEntity().posX && this.mc.getRenderViewEntity().posZ >= this.mc.getRenderViewEntity().posY) {
            width = this.font.getStringWidth("Z: " + (int) this.mc.getRenderViewEntity().posZ);
        }
        Gui.drawRect(pos.getAbsouluteX() - 1, pos.getAbsouluteY() - 1, pos.getAbsouluteX() + width + 2, pos.getAbsouluteY() + this.getHeight() + 1, background.getRGB());
        this.font.drawString("X: " + (int) this.mc.getRenderViewEntity().posX, pos.getAbsouluteX() + 1, pos.getAbsouluteY() + 1, -1);
        this.font.drawString("Y: " + (int) this.mc.getRenderViewEntity().posY, pos.getAbsouluteX() + 1, pos.getAbsouluteY() + 1 + this.font.FONT_HEIGHT, -1);
        this.font.drawString("Z: " + (int) this.mc.getRenderViewEntity().posZ, pos.getAbsouluteX() + 1, pos.getAbsouluteY() + 1 + this.font.FONT_HEIGHT * 2, -1);
    }
}
