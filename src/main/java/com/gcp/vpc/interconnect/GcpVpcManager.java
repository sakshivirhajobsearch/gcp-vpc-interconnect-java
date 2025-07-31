package com.gcp.vpc.interconnect;

import com.google.cloud.compute.v1.InsertNetworkRequest;
import com.google.cloud.compute.v1.Network;
import com.google.cloud.compute.v1.NetworksClient;
import com.google.cloud.compute.v1.Operation;

public class GcpVpcManager {

	public void createVpcNetwork(String projectId, String networkName) throws Exception {

		try (NetworksClient networksClient = NetworksClient.create()) {
			Network network = Network.newBuilder().setName(networkName).setAutoCreateSubnetworks(false) // custom-mode
																										// VPC
					.build();

			InsertNetworkRequest request = InsertNetworkRequest.newBuilder().setProject(projectId)
					.setNetworkResource(network).build();

			Operation operation = networksClient.insertAsync(request).get();

			if (operation.hasError()) {
				System.out.println("❌ Failed to create VPC: " + operation.getError());
			} else {
				System.out.println("✅ VPC Created: " + networkName);
			}
		}
	}
}
