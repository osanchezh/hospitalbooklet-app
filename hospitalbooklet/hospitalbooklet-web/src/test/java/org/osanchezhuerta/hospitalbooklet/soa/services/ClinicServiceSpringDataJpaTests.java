
package org.osanchezhuerta.hospitalbooklet.soa.services;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@ContextConfiguration(locations = {"classpath:spring/hospitalbooklet-soa-services/hospitalbooklet-soa-services-appctx.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("spring-data-jpa")
public class ClinicServiceSpringDataJpaTests extends AbstractClinicServiceTests {

}