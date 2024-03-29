package filter;

import static seriallistener.SerialDataCommunicator.INPUTS;
import seriallistener.DataVO;
import util.Interpolator;

public class DataInterpolationFilter extends DataFilter {

	private final Interpolator[] interpolator = new Interpolator[INPUTS];
	

	public Interpolator getInterpolator(int n) {
		return interpolator[n];
	}
	
	public void setInterpolator(int n, Interpolator interpolator) {
		this.interpolator[n] = interpolator;
	}
	
	
	
	@Override
	protected void filter(DataVO data) {
		
		for (int n=0; n < INPUTS; n++) {
			if (interpolator[n] != null) {
				final double value = data.getFilteredValue(n);
				data.setFilteredValue(n, interpolator[n].getValue(value));
			}
		}
		
	}

}
