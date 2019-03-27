package hamdev.tantalusunchained.machines.ResourceHarvester;

import hamdev.tantalusunchained.TantalusUnchained;
import hamdev.tantalusunchained.tools.ResourceButton;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GuiResourceHarvester extends GuiContainer
{
    private static final Logger LOGGER = LogManager.getLogger();

    public static final int WIDTH = 180;
    public static final int HEIGHT = 152;

    private static final ResourceLocation background = new ResourceLocation(TantalusUnchained.MODID, "textures/gui/resource_harvester.png");
    private static final ResourceLocation iconOne = new ResourceLocation(TantalusUnchained.MODID, "textures/items/rare_metal.png");

    private TileResourceHarvester resourceHarvester;

    public GuiResourceHarvester(TileResourceHarvester tileEntity, ContainerResourceHarvester container)
    {
        super(container);

        xSize = WIDTH;
        ySize = HEIGHT;

        resourceHarvester = tileEntity;

    }

    @Override
    protected void initGui() {
        super.initGui();
        //ResourceButton resButton = new ResourceButton(1, guiLeft + 50, guiTop + 20, 80, 20, "R");
        buttons.add(new ResourceButton(1, guiLeft + 50, guiTop + 20, 20, 20, "R"));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        mc.getTextureManager().bindTexture(background);
        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        drawDefaultBackground();
        super.render(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }
}
