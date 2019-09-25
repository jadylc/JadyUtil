package jady.test;

import com.google.common.collect.Lists;
import org.apache.commons.beanutils.PropertyUtils;
import org.springframework.cglib.beans.BeanCopier;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by liuhan on 2019/9/24.
 */
public class testCopy {
    private static MobileCardCompanyDO getM(){
        MobileCardCompanyDO cardPayOrderModel = new MobileCardCompanyDO();
        cardPayOrderModel.setCompanyCode("HS");
        cardPayOrderModel.setCompanyDesc("a1231241241awdasdf");
        cardPayOrderModel.setCompanyName("123124dzvsds");
        cardPayOrderModel.setId(2l);
        cardPayOrderModel.setStatus("1");
        cardPayOrderModel.setList(Lists.newArrayList("123","321"));
        UserForTest userForTest = new UserForTest();
        userForTest.setAge(134);
        userForTest.setId(1L);
        userForTest.setName("nanme0");
        userForTest.setScore(0.125);
        cardPayOrderModel.setUserForTest(userForTest);
        return cardPayOrderModel;
    }
    public static void main(String[] args) {




        /**
         * 10W次
         * BeanUtils.copyProperties：718
         * beanCopier.copy：56
         */

        /**
         * 100W次
         * BeanUtils.copyProperties：5673
         * beanCopier.copy：70
         */

        //BeanUtils性能
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            try {
                MobileCardCompanyDO cardPayOrderModel = getM();
                CompanyModel companyModel = new CompanyModel();
                org.apache.commons.beanutils.BeanUtils.copyProperties(companyModel, cardPayOrderModel);
                System.currentTimeMillis();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.print("apache beanutils cost = ");
        System.out.println(end - start);

        //BeanUtils性能
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            MobileCardCompanyDO cardPayOrderModel = getM();
            CompanyModel companyModel = new CompanyModel();
            org.springframework.beans.BeanUtils.copyProperties(cardPayOrderModel, companyModel);
        }
        long end2 = System.currentTimeMillis();
        System.out.print("spring beanutils cost = ");
        System.out.println(end2 - start2);

        //BeanUtils性能
        long start3 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            try {
                MobileCardCompanyDO cardPayOrderModel = getM();
                CompanyModel companyModel = new CompanyModel();
                PropertyUtils.copyProperties(companyModel, cardPayOrderModel);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        long end3 = System.currentTimeMillis();
        System.out.print("propertyutils cost = ");
        System.out.println(end3 - start3);

        //BeanCopier性能
        long start1 = System.currentTimeMillis();
        BeanCopier beanCopier = BeanCopier.create(MobileCardCompanyDO.class, CompanyModel.class,
                false);
        for (int i = 0; i < 1000000; i++) {
            MobileCardCompanyDO cardPayOrderModel = getM();
            CompanyModel companyModel = new CompanyModel();
            beanCopier.copy(cardPayOrderModel, companyModel, null);
        }
        long end1 = System.currentTimeMillis();
        System.out.print("beanCopier cost = ");
        System.out.println(end1 - start1);



        long start4 = System.currentTimeMillis();

        for (int i = 0; i < 1000000; i++) {
            MobileCardCompanyDO cardPayOrderModel = getM();
            CompanyModel companyModel = new CompanyModel();
            companyModel.setCompanyCode(cardPayOrderModel.getCompanyCode());
            companyModel.setCompanyDesc(cardPayOrderModel.getCompanyDesc());
            companyModel.setCompanyName(cardPayOrderModel.getCompanyName());
            companyModel.setId(cardPayOrderModel.getId());
            companyModel.setList(cardPayOrderModel.getList());
            companyModel.setStatus(cardPayOrderModel.getStatus());
            UserForTest userForTest1 = new UserForTest();
            userForTest1.setScore(cardPayOrderModel.getUserForTest().getScore());
            userForTest1.setName(cardPayOrderModel.getUserForTest().getName());
            userForTest1.setId(cardPayOrderModel.getUserForTest().getId());
            userForTest1.setAge(cardPayOrderModel.getUserForTest().getAge());
            companyModel.setUserForTest(userForTest1);
        }
        long end4 = System.currentTimeMillis();
        System.out.print("getset cost = ");
        System.out.println(end4 - start4);
    }
}
