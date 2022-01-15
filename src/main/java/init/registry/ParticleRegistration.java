package com.your_mod_name.your_mod.init.registry;

import com.your_mod_name.your_mod.Your_Mod;
import com.your_mod_name.your_mod.client.particle.particles.*;
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

/**
 * Author: Tony Sax
 */

@Mod.EventBusSubscriber(modid = Your_Mod.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class ParticleRegistration {

	public static final DeferredRegister<ParticleType<?>> PARTICLES_TYPES = DeferredRegister.create(
			ForgeRegistries.PARTICLE_TYPES, Your_Mod.MODID);

	public static final RegistryObject<ParticleType<FlameParticleData>> FLAME_PARTICLE = PARTICLES_TYPES.register(
			"flame_particle",
			FlameParticleType::new);

	public static ParticleType<FlameParticleData> flameParticleType; // this may not be needed

	@SuppressWarnings("resource")
	@SubscribeEvent
	public static void registerParticleFactory(ParticleFactoryRegisterEvent event) {
		Minecraft.getInstance().particleEngine.register(ParticleRegistration.FLAME_PARTICLE.get(), FlameParticleFactory::new);
	}
}
