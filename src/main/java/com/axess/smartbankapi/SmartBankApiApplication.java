package com.axess.smartbankapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.axess.smartbankapi.model.Role;
import com.axess.smartbankapi.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.axess.smartbankapi.model.CCUser;
import com.axess.smartbankapi.model.RewardsCatalogue;
import com.axess.smartbankapi.service.CCUserService;
import com.axess.smartbankapi.service.RewardCatalogueService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SmartBankApiApplication implements CommandLineRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SmartBankApiApplication.class);

	@Autowired
	private CCUserService userService;
	@Autowired
	private RewardCatalogueService rcService;
	@Autowired
	private RoleService roleService;

	public static void main(String[] args) {
		SpringApplication.run(SmartBankApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		LOGGER.info(this.roleService.saveAllRole(this.loadRolesData()));
		LOGGER.info(this.userService.saveAllUsers(this.loadUsersData()));
		LOGGER.info(this.rcService.saveAllItems(this.loadCatalogueData()));

		userService.addRoleToUser("axess1", "ROLE_USER");
		userService.addRoleToUser("axess2", "ROLE_USER");
		userService.addRoleToUser("axess3", "ROLE_ADMIN");
	}

	private List<Role> loadRolesData(){
		List<Role> rolelist = new ArrayList<>();

		Role role = new Role();
		role.setId(1L);
		role.setName("ROLE_USER");
		rolelist.add(role);

		role = new Role();
		role.setId(2L);
		role.setName("ROLE_ADMIN");
		rolelist.add(role);

		return rolelist;
	}
	
	private List<RewardsCatalogue> loadCatalogueData() {
		List<RewardsCatalogue> catalogueItems = new ArrayList<>();
		
		RewardsCatalogue item = new RewardsCatalogue();
		item.setItem("Amazon Voucher");
		item.setRedeemptionAmount(500);
		item.setRedeemptionPoint(1500);
		catalogueItems.add(item);
		
		item = new RewardsCatalogue();
		item.setItem("Amazon Voucher");
		item.setRedeemptionAmount(750);
		item.setRedeemptionPoint(2500);
		catalogueItems.add(item);
		
		item = new RewardsCatalogue();
		item.setItem("Starbucks Voucher");
		item.setRedeemptionAmount(350);
		item.setRedeemptionPoint(1000);
		catalogueItems.add(item);
		
		item = new RewardsCatalogue();
		item.setItem("Walmart Voucher");
		item.setRedeemptionAmount(500);
		item.setRedeemptionPoint(1500);
		catalogueItems.add(item);
		
		item = new RewardsCatalogue();
		item.setItem("Uber Voucher");
		item.setRedeemptionAmount(500);
		item.setRedeemptionPoint(1500);
		catalogueItems.add(item);
		
		
		return catalogueItems;
	}

	private List<CCUser> loadUsersData() {
		List<CCUser> users = new ArrayList<CCUser>();

		CCUser user = new CCUser();
		user.setUserId("axess1");
		user.setPassword(encryptedPassword());
		user.setUserName("Peter Hanks");
		user.setCcName("Smart Bank Credit Card");
		user.setCcNumber(123456789);
		user.setTotalRewardsGained(0);
		user.setAvailableRedeemPoints(10000);
		user.setRoles(new ArrayList<>());
		users.add(user);
		
		user = new CCUser();
		user.setUserId("axess2");
		user.setPassword(encryptedPassword());
		user.setUserName("Harry Simson");
		user.setCcName("Smart Bank Credit Card");
		user.setCcNumber(123456799);
		user.setTotalRewardsGained(0);
		user.setAvailableRedeemPoints(10000);
		user.setRoles(new ArrayList<>());
		users.add(user);
		
		user = new CCUser();
		user.setUserId("axess3");
		user.setPassword(encryptedPassword());
		user.setUserName("Tom Willis");
		user.setCcName("Smart Bank Credit Card");
		user.setCcNumber(123456889);
		user.setTotalRewardsGained(0);
		user.setAvailableRedeemPoints(10000);
		user.setRoles(new ArrayList<>());
		users.add(user);

		return users;
	}

	private String encryptedPassword(){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode("abc@123");
		return encodedPassword;
	}

}
