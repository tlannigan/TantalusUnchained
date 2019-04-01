package hamdev.tantalusunchained.tools;

import hamdev.tantalusunchained.machines.ResourceHarvester.GuiResourceHarvester;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SelectorButton extends GuiButton
{
    private static final Logger LOGGER = LogManager.getLogger();

    private GuiResourceHarvester guiHarvester;

    public SelectorButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, GuiResourceHarvester gui)
    {
        super(buttonId, x, y, widthIn, heightIn, buttonText);

        guiHarvester = gui;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        if (this.visible)
        {
            Minecraft minecraft = Minecraft.getInstance();
            FontRenderer fontrenderer = minecraft.fontRenderer;
            GlStateManager.color4f(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            int i = this.getHoverState(this.hovered);
            GlStateManager.enableBlend();
            GlStateManager.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            this.renderBg(minecraft, mouseX, mouseY);
            int j = 14737632;
            if (packedFGColor != 0)
            {
                j = packedFGColor;
            }
            else
            if (!this.enabled)
            {
                j = 10526880;
            } else if (this.hovered)
            {
                j = 16777120;
            }

            this.drawCenteredString(fontrenderer, this.displayString, this.x + this.width / 2, this.y + (this.height - 8) / 2, j);
        }
    }
}
