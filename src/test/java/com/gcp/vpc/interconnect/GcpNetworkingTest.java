package com.gcp.vpc.interconnect;

import org.junit.jupiter.api.Test;

public class GcpNetworkingTest {

	@Test
	public void testVpcAndInterconnect() throws Exception {

		// ✅ Replace this with your actual GCP project ID from console
		String projectId = "adroit-standard-431618-m4";

		String networkName = "demo-vpc-network";
		String interconnectName = "demo-interconnect";
		String location = "us-central1";

		// Instantiate your manager and create resources
		GcpVpcManager vpcManager = new GcpVpcManager();
		vpcManager.createVpcNetwork(projectId, networkName);

		CloudInterconnectSimulator simulator = new CloudInterconnectSimulator();
		simulator.createInterconnectAttachment(interconnectName, location);
	}
}
