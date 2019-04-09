package hamdev.tantalusunchained.machines.ResourceHarvester;

import hamdev.tantalusunchained.TantalusUnchained;
import hamdev.tantalusunchained.networking.Messages;
import hamdev.tantalusunchained.networking.PacketMachineState;
import hamdev.tantalusunchained.tools.IHarvesterStateContainer;
import hamdev.tantalusunchained.tools.ResourceButton;
import hamdev.tantalusunchained.tools.SelectorButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.util.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static hamdev.tantalusunchained.networking.Messages.INSTANCE;

public class GuiResourceHarvester extends GuiContainer
{
    private static final Logger LOGGER = LogManager.getLogger();

    public static final int WIDTH = 180;
    public static final int HEIGHT = 152;

    private static final ResourceLocation background = new ResourceLocation(TantalusUnchained.MODID, "textures/gui/resource_harvester.png");

    private TileResourceHarvester te;

    private String[] resources;
    private int curResource;

    private int days = 0;
    private int hours = 0;

    private String texture;
    private ResourceButton resButton;

    public GuiResourceHarvester(TileResourceHarvester tileEntity, ContainerResourceHarvester container)
    {
        super(container);

        xSize = WIDTH;
        ySize = HEIGHT;

        te = tileEntity;

        if(te.hasWorld()) {
            int world = te.getWorld().getDimension().getType().getId();
            if (world == -1)
            {
                resources = new String[]{"common_metal", "dense_metal", "crystalline_solid", "liquid_hot_magma", "rare_metal"};
            }
            else if (world == 1)
            {
                resources = new String[]{"inert_gas", "ionized_gas", "liquid_hot_plasma", "unstable_gas"};
            }
            else
            {
                resources = new String[]{"hard_water", "organic_compound", "plant_fiber", "microbe", "phytoplankton", "complex_organism"};
            }
        }

        this.curResource = te.getCurResource();
        this.texture = resources[curResource];
    }

    @Override
    protected void initGui()
    {
        super.initGui();

        this.resButton = this.addButton(new ResourceButton(1, guiLeft + 25, guiTop + 20, 16, 16, "", this));

        // Current Resource backwards
        this.addButton(new SelectorButton(2, guiLeft + 25 - 20, guiTop + 20, 16, 16, "<", this)
        {
            public void onClick(double mouseX, double mouseY)
            {
                if (curResource > 0)
                {
                    curResource--;
                    updateCurResource();
                }
                else
                {
                    curResource = resources.length - 1;
                    updateCurResource();
                }
            }
        });

        // Current Resource forwards
        this.addButton(new SelectorButton(3, guiLeft + 25 + 20, guiTop + 20, 16, 16, ">", this)
        {
            public void onClick(double mouseX, double mouseY)
            {
                if (curResource < resources.length - 1)
                {
                    curResource++;
                    updateCurResource();
                }
                else
                {
                    curResource = 0;
                    updateCurResource();
                }
            }
        });

        // Days forward
        this.addButton(new SelectorButton(4, guiLeft + 70, guiTop + 10, 16, 16, "/\\", this)
        {
            public void onClick(double mouseX, double mouseY)
            {
                if (days < 7)
                {
                    days++;
                }
                else
                {
                    days = 1;
                }
            }
        });

        // Days backward
        this.addButton(new SelectorButton(4, guiLeft + 70, guiTop + 30, 16, 16, "\\/", this)
        {
            public void onClick(double mouseX, double mouseY)
            {
                if (days > 0)
                {
                    days--;
                }
                else
                {
                    days = 7;
                }
            }
        });

        // Hours forwards
        this.addButton(new SelectorButton(4, guiLeft + 88, guiTop + 10, 16, 16, "/\\", this)
        {
            public void onClick(double mouseX, double mouseY)
            {
                if (hours < 24)
                {
                    hours++;
                }
                else
                {
                    hours = 0;
                }
            }
        });

        // Hours backwards
        this.addButton(new SelectorButton(4, guiLeft + 88, guiTop + 30, 16, 16, "\\/", this)
        {
            public void onClick(double mouseX, double mouseY)
            {
                if (hours > 0)
                {
                    hours--;
                }
                else
                {
                    hours = 24;
                }
            }
        });
    }

    public void updateCurResource()
    {
        texture = resources[curResource];
        resButton.reRender(new ResourceLocation(TantalusUnchained.MODID, "textures/items/" + texture + ".png"));

        te.setCurResource(curResource);
        INSTANCE.sendToServer(new PacketMachineState(curResource));
        te.markDirty();
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
        this.drawString(fontRenderer, Integer.toString(days), 75, 25, 16777215);
        this.drawString(fontRenderer, Integer.toString(hours), 90, 25, 16777215);
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

    public String getTexture()
    {
        return texture;
    }
}
