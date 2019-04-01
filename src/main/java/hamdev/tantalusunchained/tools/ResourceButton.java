package hamdev.tantalusunchained.tools;

import hamdev.tantalusunchained.machines.ResourceHarvester.GuiResourceHarvester;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class ResourceButton extends GuiButton
{
    private GuiResourceHarvester guiHarvester;

    public ResourceButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, GuiResourceHarvester gui)
    {
        super(buttonId, x, y, widthIn, heightIn, buttonText);

        guiHarvester = gui;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        Minecraft mc = Minecraft.getInstance();
        mc.getTextureManager().bindTexture(guiHarvester.getRenderedResource());

        drawModalRectWithCustomSizedTexture(this.x, this.y, 0, 0, this.width, this.height, 16, 16);
    }

    public void reRender(ResourceLocation resource)
    {
        Minecraft mc = Minecraft.getInstance();
        mc.getTextureManager().bindTexture(resource);
        drawModalRectWithCustomSizedTexture(this.x, this.y, 0, 0, this.width, this.height, 16, 16);
    }
}
