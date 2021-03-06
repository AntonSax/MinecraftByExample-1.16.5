package com.your_mod_name.your_mod.client.particle.particles;

// example from github user TheGreyGhost
//package minecraftbyexample.mbe50_particle;

import com.your_mod_name.your_mod.client.particle.particles.FlameParticle;

import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.IAnimatedSprite;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.world.ClientWorld;

import javax.annotation.Nullable;

/**
 * Author: Tony Sax and TheGreyGhost
 * Based on work by TGG that was created on 25/03/2020.
 * On the client side:
 * When the client wants to spawn a Particle, it gives the FlameParticleData to this factory method
 * The factory selects an appropriate Particle class and instantiates it
 */
public class FlameParticleFactory implements IParticleFactory<FlameParticleData> {  //IParticleFactory

	private final IAnimatedSprite sprites;  // contains a list of textures; choose one using either
	// not sure if i still need this
	// newParticle.selectSpriteRandomly(sprites); or newParticle.selectSpriteWithAge(sprites);

	// this method is needed for proper registration of your Factory:
	// The ParticleManager.register method creates a Sprite and passes it to your factory for subsequent use when rendering, then
	//   populates it with the textures from your textures/particle/xxx.json

	public FlameParticleFactory(IAnimatedSprite sprite) {
		this.sprites = sprite;
	}

	@Nullable
	@Override
	public Particle createParticle(FlameParticleData flameParticleData, ClientWorld world, double xPos, double yPos, double zPos, double xVelocity, double yVelocity, double zVelocity) {
		FlameParticle newParticle = new FlameParticle(world, xPos, yPos, zPos, xVelocity, yVelocity, zVelocity,
				flameParticleData.getTint(), flameParticleData.getDiameter(), sprites);
		newParticle.pickSprite(sprites); // not quite the newParticle.selectSpriteRandomly(sprites) that was used.
		return newParticle;
	}

	// This is private to prevent you accidentally registering the Factory using the default constructor.
	// ParticleManager has two register methods, and if you use the wrong one the game will enter an infinite loop
	private FlameParticleFactory() {
		throw new UnsupportedOperationException("Use the FlameParticleFactory(IAnimatedSprite sprite) constructor");
	}

}
