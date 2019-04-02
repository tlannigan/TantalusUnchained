package hamdev.tantalusunchained.machines.ResourceHarvester;

import hamdev.tantalusunchained.TantalusUnchained;
import hamdev.tantalusunchained.tools.ResourceButton;
import hamdev.tantalusunchained.tools.SelectorButton;
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

    private TileResourceHarvester tileHarvester;

    private String[] resources;
    //private int curResource = 0;

    public String getTexture() {
        return texture;
    }

    private static String texture;
    private ResourceLocation renderedResource = new ResourceLocation(TantalusUnchained.MODID,"textures/items/" + texture + ".png");

    private ResourceButton resButton;

    public GuiResourceHarvester(TileResourceHarvester tileEntity, ContainerResourceHarvester container)
    {
        super(container);

        xSize = WIDTH;
        ySize = HEIGHT;

        tileHarvester = tileEntity;

        resources = tileHarvester.getResources();
        texture = tileHarvester.getResources()[tileHarvester.getCurResource()];

//        if(tileHarvester.hasWorld()) {
//            int world = tileHarvester.getWorld().getDimension().getType().getId();
//            if (world == -1) {
//                tileHarvester.setResources(new String[]{"common_metal", "dense_metal", "crystalline_solid", "liquid_hot_magma", "rare_metal"});
//            } else if (world == 1) {
//                tileHarvester.setResources(new String[]{"inert_gas", "ionized_gas", "liquid_hot_plasma", "unstable_gas"});
//            } else {
//                tileHarvester.setResources(new String[]{"hard_water", "organic_compound", "plant_fiber", "microbe", "phytoplankton", "complex_organism"});
//            }
//        }
    }

    @Override
    protected void initGui()
    {
        super.initGui();

        this.resButton = this.addButton(new ResourceButton(1, guiLeft + 25, guiTop + 20, 16, 16, "", this));

        this.addButton(new SelectorButton(2, guiLeft + 25 - 20, guiTop + 20, 16, 16, "<", this)
        {
            public void onClick(double mouseX, double mouseY)
            {
                if (tileHarvester.getCurResource() > 0)
                {
                    tileHarvester.setCurResource(tileHarvester.getCurResource() - 1);
                    texture = resources[tileHarvester.getCurResource()];
                    renderedResource = new ResourceLocation(TantalusUnchained.MODID,"textures/items/" + texture + ".png");
                    resButton.reRender(renderedResource);
                }
                else
                {
                    tileHarvester.setCurResource(resources.length - 1);
                    texture = resources[tileHarvester.getCurResource()];
                    renderedResource = new ResourceLocation(TantalusUnchained.MODID,"textures/items/" + texture + ".png");
                    resButton.reRender(renderedResource);
                }
            }
        });

        this.addButton(new SelectorButton(3, guiLeft + 25 + 20, guiTop + 20, 16, 16, ">", this)
        {
            public void onClick(double mouseX, double mouseY)
            {
                if (tileHarvester.getCurResource() < resources.length - 1)
                {
                    tileHarvester.setCurResource(tileHarvester.getCurResource() + 1);
                    texture = resources[tileHarvester.getCurResource()];
                    renderedResource = new ResourceLocation(TantalusUnchained.MODID,"textures/items/" + texture + ".png");
                    resButton.reRender(renderedResource);
                }
                else
                {
                    tileHarvester.setCurResource(0);
                    texture = resources[tileHarvester.getCurResource()];
                    renderedResource = new ResourceLocation(TantalusUnchained.MODID,"textures/items/" + texture + ".png");
                    resButton.reRender(renderedResource);
                }
            }
        });
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        this.mc.getTextureManager().bindTexture(background);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        super.drawGuiContainerForegroundLayer(mouseX, mouseY);
        this.drawString(fontRenderer, texture, 10, 10, 16777215);
        this.mc.getTextureManager().bindTexture(new ResourceLocation(TantalusUnchained.MODID, "textures/gui/progress_bar.png"));
        drawModalRectWithCustomSizedTexture(10, 50, 0, 0, 64, 4, 64, 8);
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        drawDefaultBackground();
        super.render(mouseX, mouseY, partialTicks);
        renderHoveredToolTip(mouseX, mouseY);
    }

    public ResourceLocation getRenderedResource()
    {
        return renderedResource;
    }
}
