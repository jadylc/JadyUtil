package jady.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.beans.BeanCopier;

/**
 * Created by liuhan on 2019/9/9.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class UserForTest {
    private String name;
    private Long id;
    private Integer age;
    private Double score;

    public static void main(String[] args) {
        UserForTest userForTest =new UserForTest();
        BeanCopier.create(null,UserForTest.class,false);
        System.out.printf("1");
    }
}
