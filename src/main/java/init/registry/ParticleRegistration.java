package com.pixelmonmod.pixelmon.init.registry;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.client.particle.particles.*;
import net.minecraft.client.Minecraft;
import net.minecraft.particles.ParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.awt.*;

@Mod.EventBusSubscriber(modid = Pixelmon.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ParticleRegistration {

	public static final DeferredRegister<ParticleType<?>> PARTICLES_TYPES = DeferredRegister.create(
			ForgeRegistries.PARTICLE_TYPES, Pixelmon.MODID);

	//public static final RegistryObject<ParticleType<ColoredParticleData>> COLORED_PARTICLE = PARTICLES_TYPES.register(
	//		"colored_particle",
	//		() -> new ParticleType<ColoredParticleData>(false, ColoredParticleData.DESERIALIZER));
	public static final RegistryObject<ParticleType<FlameParticleData>> FLAME_PARTICLE = PARTICLES_TYPES.register(
			"flame_particle",
			FlameParticleType::new);

	public static ParticleType<FlameParticleData> flameParticleType;

	@SuppressWarnings("resource")
	@SubscribeEvent
	public static void registerParticleFactory(ParticleFactoryRegisterEvent event) {
		// from 1.15 video
		//Minecraft.getInstance().particles.registerFactory(ParticleRegistry.COLORED_PARTICLE.get(),
		//		ColoredParticle.Factory::new);
		// from 1.16 auto completion
		//Minecraft.getInstance().particleEngine.register(ParticleRegistry.COLORED_PARTICLE.get(),
		//		ColoredParticle.Factory::new);
		//Minecraft.getInstance().particleEngine.register(ParticleRegistry.COLORED_PARTICLE.get(),
		//		new ColoredParticle.Factory(Color.RED)); // needs IAnimatedSprite parameter

		// from TheGreyGhost's MinecraftByExample
		Minecraft.getInstance().particleEngine.register(ParticleRegistration.FLAME_PARTICLE.get(), FlameParticleFactory::new);
	}
}
