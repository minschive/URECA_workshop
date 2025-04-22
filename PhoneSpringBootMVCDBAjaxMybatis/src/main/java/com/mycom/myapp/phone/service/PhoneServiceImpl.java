package com.mycom.myapp.phone.service;

import com.mycom.myapp.phone.dao.PhoneDao;
import com.mycom.myapp.phone.dto.PhoneDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {

    private final PhoneDao phoneDao;

    public PhoneServiceImpl(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    @Override
    public List<PhoneDto> listPhone() { return phoneDao.listPhone(); }

    @Override
    public PhoneDto detailPhone(int phoneId) {
        return phoneDao.detailPhone(phoneId);
    }

    @Override
    public int insertPhone(PhoneDto phoneDto) {
        return phoneDao.insertPhone(phoneDto);
    }

    @Override
    public int updatePhone(PhoneDto phoneDto) {
        return phoneDao.updatePhone(phoneDto);
    }

    @Override
    public int deletePhone(int phoneId) {
        return phoneDao.deletePhone(phoneId);
    }
}
