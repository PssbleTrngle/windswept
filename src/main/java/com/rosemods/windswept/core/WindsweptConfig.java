package com.rosemods.windswept.core;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import org.apache.commons.lang3.tuple.Pair;

@EventBusSubscriber(modid = Windswept.MODID)
public class WindsweptConfig {	
	public static final Common COMMON;
	public static final Client CLIENT;
	public static final ForgeConfigSpec COMMON_SPEC;
	public static final ForgeConfigSpec CLIENT_SPEC;
	
	public static class Common {
		public final ConfigValue<Boolean> iceBoatNerf;
		public final ConfigValue<Boolean> birchBranches;
		public final ConfigValue<Boolean> strays;
		public final ConfigValue<Boolean> roots;

		private Common(ForgeConfigSpec.Builder builder) {
			builder.comment("Vanilla Gameplay Tweaks");
			builder.push("tweaks");
			this.birchBranches = builder.comment("Tall Birch Trees will generate branches growing out the side of the tree.").define("birch-branches", true);
			this.strays = builder.comment("All skeletons that spawn in snowy biomes are replaced with strays").define("strays-only", true);
			this.iceBoatNerf = builder.comment("Nerfs Boats ability to go extremely fast when on ice and other slippery blocks; default: false").define("boat-nerf", false);
			builder.pop();

			builder.comment("Tweaks to Windswept Worldgen");
			builder.push("worldgen");
			this.roots = builder.comment("Roots will grow under the dirt block below a tree, chestnut trees overhanging logs will grow roots").define("roots", true);
			builder.pop();
		}

	}
	
	public static class Client {	
		public final ConfigValue<Boolean> powderSnowParticles;
		public final ConfigValue<Boolean> largerRabbits;

		public Client(ForgeConfigSpec.Builder builder) {
			builder.push("particles");
			this.powderSnowParticles = builder.comment("If Powder Snow should drop snow particles if there is no block below.").define("powder-snow", true);
			builder.pop();

			builder.push("entity-renderers");
			this.largerRabbits = builder.comment("Rabbits will be 20% larger").define("larger-rabbits", true);
			builder.pop();
		}
		
	}
	
	static {
		final Pair<Common, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(Common::new);
		final Pair<Client, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(Client::new);
		
		COMMON = commonSpecPair.getLeft();
		CLIENT = clientSpecPair.getLeft();
		COMMON_SPEC = commonSpecPair.getRight();
		CLIENT_SPEC = clientSpecPair.getRight();
	}
	
}
