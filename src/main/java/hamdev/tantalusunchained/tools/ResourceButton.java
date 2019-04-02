package hamdev.tantalusunchained.tools;

import hamdev.tantalusunchained.TantalusUnchained;
import hamdev.tantalusunchained.machines.ResourceHarvester.GuiResourceHarvester;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;

public class ResourceButton extends GuiButton
{
    private GuiResourceHarvester guiHarvester;

    private String texture;

    public ResourceButton(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, GuiResourceHarvester gui)
    {
        super(buttonId, x, y, widthIn, heightIn, buttonText);

        guiHarvester = gui;
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        texture = guiHarvester.getTexture();
        guiHarvester.mc.getTextureManager().bindTexture(new ResourceLocation(TantalusUnchained.MODID,"textures/items/" + texture + ".png"));
        drawModalRectWithCustomSizedTexture(this.x, this.y, 0, 0, this.width, this.height, 16, 16);
    }

    public void reRender(ResourceLocation resource)
    {
        texture = guiHarvester.getTexture();
        guiHarvester.mc.getTextureManager().bindTexture(resource);
        drawModalRectWithCustomSizedTexture(this.x, this.y, 0, 0, this.width, this.height, 16, 16);
    }
}
