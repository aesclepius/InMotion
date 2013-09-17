package aesclepius.inmotion.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.network.NetworkMod.SidedPacketHandler;
import cpw.mods.fml.common.SidedProxy;
import aesclepius.inmotion.common.InMotionCommonProxy;
import aesclepius.inmotion.common.handlers.InMotionClientPacketHandler;
import aesclepius.inmotion.common.handlers.InMotionServerPacketHandler;

@NetworkMod(clientSideRequired=true,serverSideRequired=true, //Whether client side and server side are needed
clientPacketHandlerSpec = @SidedPacketHandler(channels = {"InMotion"}, packetHandler = InMotionClientPacketHandler.class), //For clientside packet handling
serverPacketHandlerSpec = @SidedPacketHandler(channels = {"InMotion"}, packetHandler = InMotionServerPacketHandler.class)) //For serverside packet handling

//MOD BASICS
@Mod(modid="InMotion",name="In Motion",version="Development")

public class InMotion {

@Instance("InMotion") //The instance, this is very important later on
public static InMotion instance = new InMotion();

@SidedProxy(clientSide = "aesclepius.inmotion.client.InMotionClientProxy", serverSide = "aesclepius.inmotion.common.InMotionCommonProxy") //Tells Forge the location of your proxies
public static InMotionCommonProxy proxy;

@PreInit
public void PreInit(FMLPreInitializationEvent e){

}

@Init
public void InitInMotion(FMLInitializationEvent event){ //Your main initialization method

//MULTIPLAYER ABILITY
NetworkRegistry.instance().registerGuiHandler(this, proxy); //Registers the class that deals with GUI data

}
}