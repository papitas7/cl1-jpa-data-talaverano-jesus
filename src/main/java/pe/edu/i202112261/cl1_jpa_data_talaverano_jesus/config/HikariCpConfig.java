package pe.edu.i202112261.cl1_jpa_data_talaverano_jesus.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HikariCpConfig {

    @Value("${DB_WORLD_URL}")
    private String dbWorldUrl;
    @Value("${DB_WORLD_USER}")
    private String dbWorldUser;
    @Value("${DB_WORLD_PASS}")
    private String dbWorldPass;
    @Value("${DB_WORLD_DRIVER}")
    private String dbWorldDriver;

    @Bean
    public HikariDataSource hikariDataSource(){

        HikariConfig config = new HikariConfig();

        /**
         * Configurar propiedades de conexion a BD
         */
        config.setJdbcUrl(dbWorldUrl);
        config.setUsername(dbWorldUser);
        config.setPassword(dbWorldPass);
        config.setDriverClassName(dbWorldDriver);

        config.setMaximumPoolSize(30);//Máximo # de conexiones del pool.
        config.setMinimumIdle(4);//Mínimo # de conexiones inactivas del pool.
        config.setIdleTimeout(240000); //Tiempo máximo de espera para eliminar una conexión inactiva.
        config.setConnectionTimeout(45000);//Tiempo máximo de espera para conectarse a la BD.

        System.out.println("###### HikariCP initialized ######");
        return new HikariDataSource(config);

    }

}
