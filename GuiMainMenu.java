package main.pvp.client.gui;

import net.minecraft.client.gui.GuiLanguage;
import net.minecraft.client.gui.GuiMultiplayer;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiSelectWorld;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class MainMenu extends GuiScreen {
	
	// minecraft custom main menu made by BisN

	public MainMenu() {
		
	}
	
	public void initGui() {
		
		
		
	}
	
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		
		mc.getTextureManager().bindTexture(new ResourceLocation("main/menu.png"));
		this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
		
		this.drawGradientRect(0, height - 100, width, height, 0x00000000, 0xff000000);
		
		String[] buttons = { "Singleplayer", "   Multiplayer", "Settings", "Language", "Quit"};
		
		int count = 0;
		for(String name : buttons) {
			
			this.drawCenteredString(mc.fontRendererObj, name, (width/buttons.length) * count + (width/buttons.length)/2f + 10, height - 20, -1);
			count++;
		}
		
		GlStateManager.pushMatrix();
		GlStateManager.translate(width/2f, height/2f, 0);
		GlStateManager.scale(2, 2, 1);
		GlStateManager.translate(-(width/2f), -(height/2f - mc.fontRendererObj.FONT_HEIGHT/2f), 0);

		this.drawCenteredString(mc.fontRendererObj, "main", width/2f, height/2f - mc.fontRendererObj.FONT_HEIGHT/2f, -1);
		
		GlStateManager.popMatrix();
	}
	
	public void mouseClicked(int mouseX, int mouxeY, int button) {
		
			String[] buttons = { "Singleplayer", "   Multiplayer", "Settings", "Language", "Quit" };
		//	String[] buttons = { "Singleplayer", "   Multiplayer", "Settings", "Language", "Quit" };
		
		int count = 0;
		for(String name : buttons) {
			
			float x = (width/buttons.length) * count + (width/buttons.length)/2f + 0 - mc.fontRendererObj.getStringWidth(name)/2f;
			float y = height - 20;
			
			if(mouseX >= x && mouxeY >= y && mouseX < x + mc.fontRendererObj.getStringWidth(name) && mouxeY < y + mc.fontRendererObj.FONT_HEIGHT) {
				switch(name) {
				
				case "Single":
					mc.displayGuiScreen(new GuiSelectWorld(this));
				break;
				
				case "Multi":
					mc.displayGuiScreen(new GuiMultiplayer(this));
				break;
				
				case "Settings":
					mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
				break;
				
				case "Language":
					mc.displayGuiScreen(new GuiLanguage(this, mc.gameSettings, mc.getLanguageManager()));
				break;
				
				case "Quit":
					mc.shutdown();
				
				}
				
				
			}
			
			count++;
		}
		
	}
	
	public void onGuiClosed() {
		
		
		
	}
	
}
 
