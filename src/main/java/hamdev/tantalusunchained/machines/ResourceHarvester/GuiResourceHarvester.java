package hamdev.tantalusunchained.machines.ResourceHarvester;

import hamdev.tantalusunchained.TantalusUnchained;
import hamdev.tantalusunchained.tools.ResourceButton;
import hamdev.tantalusunchained.tools.SelectorButton;
import net.minecraft.client.gui.GuiLabel;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class GuiResourceHarvester extends GuiContainer
{
    private static final Logger LOGGER = LogManager.getLogger();

    public static final int WIDTH = 180;
    public static final int HEIGHT = 152;

    private static final ResourceLocation background = new ResourceLocation(TantalusUnchained.MODID, "textures/gui/resource_harvester.png");

    private TileResourceHarvester resourceHarvester;

    private static String[] resources;
    private static int curResource = 0;

    public String getTexture() {
        return texture;
    }

    private static String texture = "common_metal";

    private static ResourceLocation renderedResource = new ResourceLocation(TantalusUnchained.MODID,"textures/items/" + texture + ".png");

    private ResourceButton resButton;

    private SelectorButton selectMinus;
    private SelectorButton selectPlus;

    public GuiResourceHarvester(TileResourceHarvester tileEntity, ContainerResourceHarvester container)
    {
        super(container);

        xSize = WIDTH;
        ySize = HEIGHT;

        resourceHarvester = tileEntity;
        int world = resourceHarvester.getWorld().getDimension().getType().getId();

        if(world == -1)
        {
            resources = new String[] {"common_metal", "dense_metal", "crystalline_solid", "liquid_hot_magma", "rare_metal"};
        }
        else if (world == 1)
        {
            resources = new String[] {"inert_gas", "ionized_gas", "liquid_hot_plasma", "unstable_gas"};
        }
        else
        {
            resources = new String[] {"hard_water", "organic_compound", "plant_fiber", "microbe", "phytoplankton", "complex_organism"};
        }
    }

    @Override
    protected void initGui()
    {
        super.initGui();

        this.resButton = this.addButton(new ResourceButton(1, guiLeft + 25, guiTop + 20, 16, 16, "", this));

        this.selectMinus = this.addButton(new SelectorButton(2, guiLeft + 25 - 20, guiTop + 20, 16, 16, "<", this)
        {
            public void onClick(double mouseX, double mouseY)
            {
                if (curResource > 0)
                {
                    curResource--;
                    texture = resources[curResource];
                    renderedResource = new ResourceLocation(TantalusUnchained.MODID,"textures/items/" + texture + ".png");
                    resButton.reRender(renderedResource);
                }
                else
                {
                    curResource = resources.length - 1;
                    texture = resources[curResource];
                    renderedResource = new ResourceLocation(TantalusUnchained.MODID,"textures/items/" + texture + ".png");
                    resButton.reRender(renderedResource);
                }
            }
        });

        this.selectPlus = this.addButton(new SelectorButton(3, guiLeft + 25 + 20, guiTop + 20, 16, 16, ">", this)
        {
            public void onClick(double mouseX, double mouseY)
            {
                if (curResource < resources.length - 1)
                {
                    curResource++;
                    texture = resources[curResource];
                    renderedResource = new ResourceLocation(TantalusUnchained.MODID,"textures/items/" + texture + ".png");
                    resButton.reRender(renderedResource);
                }
                else
                {
                    curResource = 0;
                    texture = resources[curResource];
                    renderedResource = new ResourceLocation(TantalusUnchained.MODID,"textures/items/" + texture + ".png");
                    resButton.reRender(renderedResource);
                }
            }
        });
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        mc.getTextureManager().bindTexture(background);

        drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        drawString(fontRenderer, texture, 10, 10, 16777215);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        drawDefaultBackground();
        super.render(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }

    public static ResourceLocation getRenderedResource()
    {
        return renderedResource;
    }
}
