package edu.boun.edgecloudsim.edge_server;

import java.util.ArrayList;
import java.util.List;

import org.cloudbus.cloudsim.Datacenter;
import org.cloudbus.cloudsim.Host;
import org.cloudbus.cloudsim.VmAllocationPolicy;

public abstract class EdgeServerManager {
	protected List<Datacenter> localDatacenters;
	protected List<List<EdgeVM>> vmList;

	public EdgeServerManager() {
		localDatacenters=new ArrayList<Datacenter>();
		vmList = new ArrayList<List<EdgeVM>>();
	}

	public List<EdgeVM> getVmList(int hostId){
		return vmList.get(hostId);
	}
	
	public List<Datacenter> getDatacenterList(){
		return localDatacenters;
	}
	
	/*
	 * initialize edge server manager if needed
	 */
	public abstract void initialize();

	/*
	 * provides abstract Vm Allocation Policy for Edge Datacenters
	 */
	public abstract VmAllocationPolicy getVmAllocationPolicy(List<? extends Host> list, int dataCenterIndex);

	/*
	 * Starts Datacenters
	 */
	public abstract void startDatacenters() throws Exception;
	
	/*
	 * Terminates Datacenters
	 */
	public abstract void terminateDatacenters();
	/*
	 * Creates VM List
	 */
	public abstract void createVmList(int brockerId);
	
	/*
	 * returns average utilization of all VMs
	 */
	public abstract double getAvgUtilization();
}