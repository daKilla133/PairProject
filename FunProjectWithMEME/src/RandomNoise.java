import MathLogic.Noise;

public class RandomNoise {

	public float octavedNoise(float x, float y, Noise n) {
		return
				(float) ((n.noise(x, y, 1f) * 1 + 
				n.noise(x, y, 2f) * 2 +  
				n.noise(x, y, 4f) * 4 +  
				n.noise(x, y, 8f) * 8 +
				n.noise(x, y, 16f) * 16) / (1 + 2 + 4 + 8 + 16));
	}
	public float octavedNoise(int octaves, float roughness, float scale, Noise n) {
		float noiseSum = 0;
		float layerFrequency = scale;
		float layerWeight = 1;
		float weightSum = 0;

		int x = 0, y = 0;
		for (int octave = 0; octave < octaves; octave++) {
			noiseSum += n.noise(x * layerFrequency, y * layerFrequency) * layerWeight;
			layerFrequency *= 2;
			weightSum += layerWeight;
			layerWeight *= roughness;
		}
		return noiseSum / weightSum;
	}
}
