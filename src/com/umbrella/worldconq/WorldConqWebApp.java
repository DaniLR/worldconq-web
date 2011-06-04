package com.umbrella.worldconq;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import com.umbrella.worldconq.comm.ClientAdapter;
import com.umbrella.worldconq.comm.ServerAdapter;
import com.umbrella.worldconq.domain.GameEventPool;
import com.umbrella.worldconq.domain.GameManager;
import com.umbrella.worldconq.domain.UserManager;

public class WorldConqWebApp {

	private UserManager userManager = null;
	private GameManager gameManager = null;
	private GameEventPool eventPool;
	private ServerAdapter serverAdapter = null;
	private ClientAdapter clientAdapter = null;

	public WorldConqWebApp() {
		try {
			clientAdapter = new ClientAdapter();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		serverAdapter = new ServerAdapter();
		try {
			serverAdapter.setRemoteInfo(
				"Server",
				InetAddress.getByName("localhost"),
				1099);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		gameManager = new GameManager(serverAdapter, clientAdapter);
		userManager = new UserManager(serverAdapter, gameManager, clientAdapter);
		gameManager.setUserManager(userManager);
		try {
			serverAdapter.connect();
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return the userManager
	 */
	public UserManager getUserManager() {
		return userManager;
	}

	/**
	 * @param userManager
	 *            the userManager to set
	 */
	protected void setUserManager(UserManager userManager) {
		this.userManager = userManager;
	}

	/**
	 * @return the gameManager
	 */
	public GameManager getGameManager() {
		return gameManager;
	}

	/**
	 * @param gameManager
	 *            the gameManager to set
	 */
	protected void setGameManager(GameManager gameManager) {
		this.gameManager = gameManager;
	}

	public GameEventPool getEventPool() {
		return eventPool;
	}

	public void setEventPool(GameEventPool eventPool) {
		this.eventPool = eventPool;
	}

}
