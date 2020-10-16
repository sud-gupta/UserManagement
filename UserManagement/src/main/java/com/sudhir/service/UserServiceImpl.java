package com.sudhir.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudhir.entity.CityEntity;
import com.sudhir.entity.CountryEntity;
import com.sudhir.entity.StateEntity;
import com.sudhir.entity.UserAccountEntity;
import com.sudhir.model.UserAccount;
import com.sudhir.repository.CityRepository;
import com.sudhir.repository.CountryRepository;
import com.sudhir.repository.StateRepository;
import com.sudhir.repository.UserAccountRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserAccountRepository userAccRepo;

	@Autowired
	private CountryRepository countryRepo;

	@Autowired
	private StateRepository stateRepo;

	@Autowired
	private CityRepository cityRepo;

	@Override
	public String loginCheck(String email, String pwd) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<Integer, String> loadCountries() {
		Map<Integer, String> countryMap = new HashMap<>();
		List<CountryEntity> entitylist = countryRepo.findAll();
		entitylist.forEach(entity -> {
			countryMap.put(entity.getCountryId(), entity.getCountryName());
		});
		return countryMap;
	}

	@Override
	public Map<Integer, String> loadStatesByCountryId(Integer countryId) {

		Map<Integer, String> stateMap = new HashMap<>();
		List<StateEntity> entitylist = stateRepo.findByCountryId(countryId);
		entitylist.forEach(entity -> {
			stateMap.put(entity.getStateId(), entity.getStateName());
		});
		return stateMap;

	}

	@Override
	public Map<Integer, String> loadCitiesByStateId(Integer stateId) {
		Map<Integer, String> cityMap = new HashMap<>();
		List<CityEntity> entitylist = cityRepo.findByStateId(stateId);
		entitylist.forEach(entity -> {
			cityMap.put(entity.getCityId(), entity.getCityName());
		});
		return cityMap;
	}

	@Override
	public boolean isUniqueEmail(String email) {
		UserAccountEntity userAccountEntity = userAccRepo.findByEmail(email);
		return userAccountEntity != null ? false : true;
	}

	@Override
	public String generateTempPwd() {
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder(6);
		for (int i = 0; i < 6; i++) {
			int index = (int) (AlphaNumericString.length() * Math.random());
			sb.append(AlphaNumericString.charAt(index));
		}
		return sb.toString();
	}

	@Override
	public boolean saveUserAccount(UserAccount userAccount) {
		userAccount.setStatus("LOCKED");
		userAccount.setPassword(generateTempPwd());
		UserAccountEntity userAccountEntity=new UserAccountEntity();
		BeanUtils.copyProperties(userAccount, userAccountEntity);
		UserAccountEntity saveEntity = userAccRepo.save(userAccountEntity);
				
		return saveEntity.getUserId() !=null ? true : false;
	}

	@Override
	public String getRegSuccMailBody(UserAccount userAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean sendRegSuccEmail(String to, String subject, String body) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isTempPwdValid(String email, String tempPwd) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean unlockAccount(String email, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String recoverPassword(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getRecoverPwdEmailBody(UserAccount userAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendPwdToEmail(String email, String subject, String body) {
		// TODO Auto-generated method stub
		return null;
	}

}
