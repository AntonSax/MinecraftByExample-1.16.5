# MinecraftByExample-1.16.5
Based on @TheGreyGhost's MinecraftByExample, this updates some of his work to work for 1.16.5.  
See https://github.com/TheGreyGhost/MinecraftByExample/tree/master/src/main/java/minecraftbyexample/mbe50_particle for his work on that.

For now this just includes a sample of Particle Registration and the other necessary files for setting up an example particle.


        

# Particles
A list of changes from @TheGreyGhost's work.

#### FlameParticle.java
* `particleScale`                          becomes `this.scale(float f)`
* `maxAge`                                 becomes `this.lifetime`
* `this.particleAlpha`                     becomes `this.alpha`
* `motionX, motionY, and motionZ`          becomes `this.xd, this.yd, and this.zd`
* `this.canCollide`                        becomes `this.hasPhysics`
* `protected int getBrightnessForRender(float partialTick)`
                                           becomes `public int getLightColor(float partialTick)`
* `LightTexture.packLight(int i, int j)`   becomes `LightTexture.pack(int i, int j)`
* `prevPosX, prevPosY, prevPosZ`           becomes `this.xo, thix.yo, this.zo`
* `posx, posY, posZ`                       becomes `this.x, this.y, this.z`
* `this.setExpired()`                      becomes `this.remove()`


# File Structure
```
- src
  - main
    - java
      - client
        - particles
          - FlameParticle.java
          - FlameParticleData.java
          - FlameParticleFactory.java
          - FlameParticleType.java
      - init
        - ParticleRegistration.java
    - resources
      - assets/mod_name
        - particles
          - flame_particle.json
        - textures
          - flame.png
```
