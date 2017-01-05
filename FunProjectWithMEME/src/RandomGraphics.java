
public class RandomGraphics {

	public float octavedNoise(float x, float y) {
		return
				(noise(x, y, 1f) * 1 + 
						noise(x, y, 2f) * 2 +  
						noise(x, y, 4f) * 4 +  
						noise(x, y, 8f) * 8 +
						noise(x, y, 16f) * 16) / (1 + 2 + 4 + 8 + 16);
	}
	public float octavedNoise(int octaves, float roughness, float scale) {
		float noiseSum = 0;
		float layerFrequency = scale;
		float layerWeight = 1;
		float weightSum = 0;

		for (int octave = 0; octave < octaves; octave++) {
			noiseSum += noise(x * layerFrequency, y * layerFrequency) * layerWeight;
			layerFrequency *= 2;
			weightSum += layerWeight;
			layerWeight *= roughness;
		}
		return noiseSum / weightSum;
	}
}
