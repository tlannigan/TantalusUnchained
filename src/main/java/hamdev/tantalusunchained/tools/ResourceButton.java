package hamdev.tantalusunchained.tools;

import hamdev.tantalusunchained.TantalusUnchained;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.config.GuiButtonExt;
import net.minecraftforge.fml.client.config.GuiUtils;

public class ResourceButton extends GuiButtonExt
{
    private static final ResourceLocation iconOne = new ResourceLocation(TantalusUnchained.MODID,"textures/items/rare_metal.png");

    public ResourceButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText) {
        super(buttonId, x, y, widthIn, heightIn, buttonText);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        super.render(mouseX, mouseY, partialTicks);

//        Minecraft mc = Minecraft.getInstance();
//        mc.getTextureManager().bindTexture(iconOne);
//        drawModalRectWithCustomSizedTexture(this.x, this.y, 0, 0, this.width, this.height, 20, 20);

        if (this.visible)
        {
            Minecraft mc = Minecraft.getInstance();
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            int k = this.getHoverState(this.hovered);
            GuiUtils.drawContinuousTexturedBox(iconOne, this.x, this.y, 0, 46 + k * 20, this.width, this.height, 16, 16, 2, 3, 2, 2, this.zLevel);
            this.renderBg(mc, mouseX, mouseY);
            int color = 14737632;

            if (packedFGColor != 0)
            {
                color = packedFGColor;
            }
            else if (!this.enabled)
            {
                color = 10526880;
            }
            else if (this.hovered)
            {
                color = 16777120;
            }

            String buttonText = this.displayString;
            int strWidth = mc.fontRenderer.getStringWidth(buttonText);
            int ellipsisWidth = mc.fontRenderer.getStringWidth("...");

            if (strWidth > width - 6 && strWidth > ellipsisWidth)
                buttonText = mc.fontRenderer.trimStringToWidth(buttonText, width - 6 - ellipsisWidth).trim() + "...";

            this.drawCenteredString(mc.fontRenderer, buttonText, this.x + this.width / 2, this.y + (this.height - 8) / 2, color);
        }
    }


}
