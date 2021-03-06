/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airline.model;

import airline.database.Database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author JoseManuel
 */
public class model {

    static Database ciudades;
    static Database vuelos;
    static Database viajes;
    static Database aviones;
    static Database usuarios;
    static Database asientos;
    static Database reservaciones;
    static Database tiquetes;

    static {
        initCiudades();
        initVuelos();
        initViajes();
        initAviones();
        initUsuarios();
        initAsientos();
        initReservaciones();
        initTiquetes();
    }

    private static void initCiudades() {
        ciudades = new Database(null, null, null);
    }

    private static void initVuelos() {
        vuelos = new Database(null, null, null);
    }

    private static void initViajes() {
        viajes = new Database(null, null, null);
    }

    private static void initAviones() {
        aviones = new Database(null, null, null);
    }

    private static void initUsuarios() {
        usuarios = new Database(null, null, null);
    }

    private static void initAsientos() {
        asientos = new Database(null, null, null);
    }
    private static void initReservaciones() {
        reservaciones = new Database(null, null, null);
    }
     private static void initTiquetes() {
        tiquetes = new Database(null, null, null);
    }



    /*--------------------------------Ciudades-----------------------------------------*/
    public static List<Ciudad> selectAllCities() throws Exception {
        List<Ciudad> cities;
        cities = new ArrayList();
        try {
            String sql = "select * from Ciudad ";
            ResultSet rs = ciudades.executeQuery(sql);
            while (rs.next()) {
                cities.add(toCiudad(rs));
            }
        } catch (SQLException ex) {
            throw new Exception("No existen registros de ciudades");
        }
        return cities;
    }

    public static Ciudad selectCity(String codigo) throws Exception {
        Ciudad c1 = new Ciudad();
        try {
            String sql = "select * from Ciudad c where c.codigo='" + codigo + "'";
            ResultSet rs = ciudades.executeQuery(sql);
            while (rs.next()) {
                c1 = toCiudad(rs);
            }
        } catch (SQLException ex) {
            throw new Exception("No existen registros de ciudades");
        }
        return c1;
    }

    public static Avion selectPlane(String codigo) throws Exception {
        Avion a1 = new Avion();
        try {
            String sql = "select * from Avion a where a.placa='" + codigo + "'";
            ResultSet rs = aviones.executeQuery(sql);
            while (rs.next()) {
                a1 = toPlanes(rs);
            }
        } catch (SQLException ex) {
            throw new Exception("No existen registros de aviones");
        }
        return a1;
    }

    public static Viaje selectTravel(int numero) throws Exception {
        Viaje v1 = new Viaje();
        try {
            String sql = "select * from Viaje v where v.numeroviaje=" + numero + "";
            ResultSet rs = viajes.executeQuery(sql);
            while (rs.next()) {
                v1 = toTravels(rs);
            }
        } catch (SQLException ex) {
            throw new Exception("No existen registros de Viajes");
        }
        return v1;
    }

    public static Vuelo selectFlight(int numero) throws Exception {
        Vuelo v1 = new Vuelo();
        try {
            String sql = "select * from Vuelo v where v.numeroVuelo=" + numero + "";
            ResultSet rs = vuelos.executeQuery(sql);
            while (rs.next()) {
                v1 = toFlights(rs);
            }
        } catch (SQLException ex) {
            throw new Exception("No existen registros de Vuelos");
        }
        return v1;
    }

    private static Ciudad toCiudad(ResultSet rs) throws Exception {
        try {
            Ciudad obj = new Ciudad();
            obj.setCodigo(rs.getString("codigo"));
            obj.setNombre(rs.getString("nombre"));
            obj.setPais(rs.getString("pais"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }

    /*-----------------------------------------------------------------------------*/
 /*-------------------------------------------Vuelos-----------------------*/
    //EL SIGUIENTE METODO agrega un vuelo
    public static int VueloAdd(Vuelo p) throws Exception {
        String sql = "insert into Vuelo (ciudadOrigen, ciudadDestino, estado,precio,"
                + "duracion,hora,oferta,imagen,dia,descuento) "
                + "values('%s','%s',%b,%s,'%s','%s',%b,'%s','%s',%s)";
        sql = String.format(sql, p.getCiudad_origen().getCodigo(), p.getCiudad_destino().getCodigo(),
                p.isEstado(), p.getPrecio(), p.getDuracion(), p.getHora(),
                p.isOferta(), p.getImagen(), p.getDia(), p.getDescuento());
        ResultSet rs = vuelos.executeUpdateWithKeys(sql);
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }
    
    public static int VueloUpdate(Vuelo p) throws Exception {
        String sql = "update Vuelo set ciudadOrigen='%s', ciudadDestino='%s', estado=%b,precio=%s,"
                + "duracion='%s',hora='%s',oferta=%b,imagen='%s',dia='%s',descuento=%s"
                + "values('%s','%s',%b,%s,'%s','%s',%b,'%s','%s',%s"
                + "where numero_vuelo='%s')";
        sql = String.format(sql, p.getCiudad_origen().getCodigo(), p.getCiudad_destino().getCodigo(),
                p.isEstado(), p.getPrecio(), p.getDuracion(), p.getHora(),
                p.isOferta(), p.getImagen(), p.getDia(), p.getDescuento(),p.getNumero_vuelo());
        ResultSet rs = vuelos.executeUpdateWithKeys(sql);
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }

    public static List<Vuelo> selectAllFlights() throws Exception {
        List<Vuelo> flights;
        flights = new ArrayList();
        try {
            String sql = "select * from Vuelo v inner join Ciudad c1 on v.ciudadOrigen = c1.codigo "
                    + "inner join Ciudad c2 on v.ciudadDestino = c2.codigo";
            ResultSet rs = vuelos.executeQuery(sql);
            while (rs.next()) {
                flights.add(toFlights(rs));
            }
        } catch (SQLException ex) {
            throw new Exception("No exiten registros de Vuelos");
        }
        return flights;
    }

    public static List<Vuelo> selectAllFlightsPromo() throws Exception {
        List<Vuelo> flights;
        flights = new ArrayList();
        try {
            String sql = "select * from Vuelo v inner join Ciudad c1 on v.ciudadOrigen = c1.codigo "
                    + "inner join Ciudad c2 on v.ciudadDestino = c2.codigo where v.oferta = true";
            ResultSet rs = vuelos.executeQuery(sql);
            while (rs.next()) {
                flights.add(toFlights(rs));
            }
        } catch (SQLException ex) {
            throw new Exception("No existen Vuelos en promocion");
        }
        return flights;
    }

    private static Vuelo toFlights(ResultSet rs) throws Exception {
        try {
            Vuelo obj = new Vuelo();
            obj.setNumero_vuelo(rs.getInt("numeroVuelo"));
            Ciudad ciudad1 = new Ciudad();
            ciudad1.setCodigo(rs.getString("ciudadOrigen"));
            ciudad1 = selectCity(ciudad1.getCodigo());
            obj.setCiudad_origen(ciudad1);
            Ciudad ciudad2 = new Ciudad();
            ciudad2.setCodigo(rs.getString("ciudadDestino"));
            ciudad2 = selectCity(ciudad2.getCodigo());
            obj.setCiudad_destino(ciudad2);
            obj.setEstado(rs.getBoolean("estado"));
            obj.setPrecio(rs.getInt("precio"));
            obj.setDuracion(rs.getString("duracion"));
            obj.setHora(rs.getString("hora"));
            obj.setOferta(rs.getBoolean("oferta"));
            obj.setImagen(rs.getString("imagen"));
            obj.setDia(rs.getString("dia"));
            obj.setDescuento(rs.getInt("descuento"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }

    /*-----------------------------------------------------------------------------*/
 /*----------------------------------------Viaje---------------------------------*/
    //EL SIGUIENTE METODO agrega un vuelo
    public static int ViajeAdd(Viaje p) throws Exception {
        String sql = "insert into Viaje (fecha, placa_avion, numero_vuelo) "
                + "values('%s','%s',%s)";
        sql = String.format(sql, new SimpleDateFormat("yyyy-MM-dd").format(p.getFecha()), p.getAvion().getPlaca(),
                p.getVuelo().getNumero_vuelo());
        ResultSet rs = viajes.executeUpdateWithKeys(sql);
        if (rs.next()) {
            String numeroAsiento;
            Asiento spot;
           p.setNumero_viaje(rs.getInt(1));
            for (int i = 0; i < p.getAvion().getCant_filas(); i++) {
                for (int j = 0; j < p.getAvion().getCant_cant_asientos_por_fila(); j++) {
                    numeroAsiento = Integer.toString(i+1) + columnaAsiento(j+1)
                            + Integer.toString( p.getNumero_viaje());
                    spot = new Asiento(numeroAsiento, true,p);
                    AsientoAdd(spot);
                }
            }
            return rs.getInt(1);
        } else {
            return 0;
        }
    }
    public static String columnaAsiento(int x){
        String asiento ="";
        switch(x){
            case 1: asiento= "A";break;
            case 2: asiento= "B";break;
            case 3: asiento= "C";break;
            case 4: asiento= "D";break;
            case 5: asiento= "E";break;
            case 6: asiento= "F";break;
            case 7: asiento= "G";break;
            case 8: asiento= "H";break;
            case 9: asiento= "I";break;
        }
        return asiento;
    }
    public static List<Viaje> selectAllTravels() throws Exception {
        List<Viaje> travels;
        travels = new ArrayList();
        try {
            String sql = "select * from Viaje vi inner join Avion a on vi.placa_avion = a.placa inner join"
                    + " Vuelo vu on vi.numero_vuelo = vu.numeroVuelo inner join  Ciudad c1 on "
                    + "vu.ciudadOrigen = c1.codigo inner join Ciudad c2 on vu.ciudadDestino = c2.codigo";
            ResultSet rs = viajes.executeQuery(sql);
            while (rs.next()) {
                travels.add(toTravels(rs));
            }
        } catch (SQLException ex) {
            throw new Exception("No existen registros de Viajes");
        }
        return travels;
    }

    public static List<Viaje> searchTravels(String origen, String destino, String dia, String fecha) throws Exception {
        List<Viaje> travels;
        travels = new ArrayList();
        try {
            String sql = "select * from Viaje vi inner join Avion a on vi.placa_avion = a.placa inner join"
                    + " Vuelo vu on vi.numero_vuelo = vu.numeroVuelo "
                    + "inner join Ciudad c1 on vu.ciudadOrigen = c1.codigo "
                    + "inner join Ciudad c2 on vu.ciudadDestino = c2.codigo where c1.nombre='"
                    + origen + "' and c2.nombre='" + destino + "' and vu.dia='" + dia + "' and vi.fecha='" + fecha + "'";
            ResultSet rs = viajes.executeQuery(sql);
            while (rs.next()) {
                travels.add(toTravels(rs));
            }
        } catch (SQLException ex) {
            throw new Exception("No existen registros de Viajes");
        }
        return travels;
    }

    private static Viaje toTravels(ResultSet rs) throws Exception {
        try {
            Viaje obj = new Viaje();
            obj.setNumero_viaje(rs.getInt("numeroviaje"));
            obj.setFecha(rs.getDate("fecha"));
            obj.setAvion(toPlanes(rs));
            obj.setVuelo(toFlights(rs));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }

    /*-------------------------------------------------------------------------*/
 /*------------------------------Avion-----------------------------------------*/
    //EL SIGUIENTE METODO agrega un avion
    public static int insertAvion(Avion avion) throws Exception {
        //  return 1;

        String sql = "insert into Avion "
                + "(placa, modelo, marca, annio, cant_pasajeros, cant_filas, cant_asientos_por_fila) "
                + "values ('%s','%s','%s','%s','%s','%s','%s')";
        sql = String.format(sql, avion.getPlaca(),
                avion.getModelo(),
                avion.getMarca(),
                avion.getAnnio(),
                avion.getCant_pasajeros(),
                avion.getCant_filas(),
                avion.getCant_cant_asientos_por_fila());
        ResultSet rs = aviones.executeUpdateWithKeys(sql);
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }
    
    
    public static int updateAvion(Avion avion) throws Exception {
        //  return 1;

        String sql = "update Avion "
                + "set modelo='%s', marca='%s', annio=%s, cant_pasajeros='%s', cant_filas='%s', cant_asientos_por_fila='%s' "
                + "where placa ='%s'";
        sql = String.format(sql,
                avion.getModelo(),
                avion.getMarca(),
                avion.getAnnio(),
                avion.getCant_pasajeros(),
                avion.getCant_filas(),
                avion.getCant_cant_asientos_por_fila(),
                avion.getPlaca());
        ResultSet rs = aviones.executeUpdateWithKeys(sql);
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }

    public static int insertCiudad(Ciudad ciudad) throws Exception {
        //  return 1;

        String sql = "insert into Ciudad "
                + "(codigo, pais, nombre) "
                + "values ('%s','%s','%s')";
        sql = String.format(sql, ciudad.getCodigo(),
                ciudad.getPais(),
                ciudad.getNombre());
        ResultSet rs = ciudades.executeUpdateWithKeys(sql);
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }
    
    public static int updateCiudad(Ciudad ciudad) throws Exception {
        //  return 1;

        String sql = "update Ciudad "
                + "set pais='%s', nombre='%s' "
                + "where codigo='%s'";
        sql = String.format(sql,
                ciudad.getPais(),
                ciudad.getNombre(),
                ciudad.getCodigo());
        ResultSet rs = ciudades.executeUpdateWithKeys(sql);
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }

    public static List<Avion> selectAllPlanes() throws Exception {
        List<Avion> planes;
        planes = new ArrayList();
        try {
            String sql = "select * from Avion";
            ResultSet rs = aviones.executeQuery(sql);
            while (rs.next()) {
                planes.add(toPlanes(rs));
            }
        } catch (SQLException ex) {
            throw new Exception("No existen registros de Aviones");
        }
        return planes;
    }

    private static Avion toPlanes(ResultSet rs) throws Exception {
        try {
            Avion obj = new Avion();
            obj.setPlaca(rs.getString("placa"));
            obj.setModelo(rs.getString("modelo"));
            obj.setMarca(rs.getString("marca"));
            obj.setAnnio(rs.getString("annio"));
            obj.setCant_pasajeros(rs.getInt("cant_pasajeros"));
            obj.setCant_filas(rs.getInt("cant_filas"));
            obj.setcant_asientos_por_fila(rs.getInt("cant_asientos_por_fila"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }

    //--------------USUARIO------------------------------------
    public static List<Usuario> selectAllUsers() throws Exception {
        List<Usuario> users;
        users = new ArrayList();
        try {
            String sql = "select * from Usuario";
            ResultSet rs = usuarios.executeQuery(sql);
            while (rs.next()) {
                users.add(toUsers(rs));
            }
        } catch (SQLException ex) {
            throw new Exception("No existen registros de usuarios");
        }
        return users;
    }

    public static Usuario userLogin(Usuario usuario) throws Exception {
        try {
            String sql = "select * from "
                    + "Usuario  u  "
                    + "where u.nombreUsuario = '%s' and u.contrasena='%s'";
            sql = String.format(sql, usuario.usuario, usuario.contrasena);

            ResultSet rs = usuarios.executeQuery(sql);
            if (rs.next()) {
                return toUsers(rs);
            } else {
                return new Usuario(usuario.usuario, usuario.contrasena, "", "", "", new Date(), "", 0, 0, 0);
            }
        } catch (SQLException ex) {
            throw new Exception("No existen registros de usuarios");
        }
    }

    private static Usuario toUsers(ResultSet rs) throws Exception {
        try {
            Usuario obj = new Usuario();
            obj.setUsuario(rs.getString("nombreUsuario"));
            obj.setContrasena(rs.getString("contrasena"));
            obj.setNombre(rs.getString("nombre"));
            obj.setApellidos(rs.getString("apellidos"));
            obj.setCorreo(rs.getString("correo"));
            obj.setFecha_nac(rs.getDate("fechaNacimiento"));
            obj.setDireccion(rs.getString("direccion"));
            obj.setTelefono(rs.getInt("telefono"));
            obj.setCelular(rs.getInt("celular"));
            obj.setTipo(rs.getInt("tipo"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }
    public static void insertUsuario(Usuario usuario) throws Exception {
        //  return 1;

        String sql = "insert into Usuario "
                + "(nombreUsuario, contrasena, nombre, apellidos, correo, fechaNacimiento,"
                + " direccion, telefono, celular, tipo) "
                + "values ('%s','%s','%s','%s','%s','%s','%s',%s,%s,%s)";
        sql = String.format(sql, usuario.getUsuario(),
                usuario.getContrasena(),
                usuario.getNombre(),
                usuario.getApellidos(),
                usuario.getCorreo(),
                new SimpleDateFormat("yyyy-MM-dd").format(usuario.getFecha_nac()),
                usuario.getDireccion(),
                usuario.getTelefono(),
                usuario.getCelular(),
                usuario.getTipo());
        int count = usuarios.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Usuario ya existente");
        }
    }

    public static boolean usuarioExiste(String nombreUsuario) throws Exception {
        List<Usuario> users;
        users = new ArrayList();
        try {
            String sql = "select * from Usuario where nombreUsuario =" + nombreUsuario;
            ResultSet rs = usuarios.executeQuery(sql);
            while (rs.next()) {
                users.add(toUsers(rs));
            }
        } catch (SQLException ex) {
            throw new Exception("No existen registros de Viajes");
        }
        if (users != null) {
            return true; //usuario ya existe
        }
        return false;
    }
    //ASientos----------------------------------------------------------------------

    private static Asiento toSits(ResultSet rs) throws Exception {
        try {
            Asiento obj = new Asiento();
            obj.setNumero(rs.getString("numero"));
            obj.setEstado(rs.getBoolean("estado"));
            Viaje v1 = new Viaje();
            v1.setNumero_viaje(rs.getInt("numero_viaje"));
            v1 = selectTravel(v1.getNumero_viaje());
            obj.setViaje(v1);
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static void AsientoAdd(Asiento p) throws Exception {
        String sql = "insert into Asiento (numero, estado, numero_viaje) "
                + "values('%s',%s,%s)";
        sql = String.format(sql, p.getNumero(), p.isEstado(), p.getViaje().getNumero_viaje());
         int count =  asientos.executeUpdate(sql);
        if (count == 0) {
            throw new Exception("Usuario ya existente");
        }

    }
      public static List<Asiento> selectSitsByTrip(Viaje p) throws Exception {
        List<Asiento> sits;
        sits = new ArrayList();
        try {
            String sql = "select * from Asiento where numero_viaje = "+p.getNumero_viaje();
            ResultSet rs = asientos.executeQuery(sql);
            while (rs.next()) {
                sits.add(toSits(rs));
            }
        } catch (SQLException ex) {
            throw new Exception("No existen asientos pare ese viaje");
        }
        return sits;
    }

    //----------------Delete ----------------------------------
    public static int deleteCiudad(String codigo) throws Exception {
        String sql = "delete from Ciudad where codigo=" + codigo + "";
        ResultSet rs = viajes.executeQuery(sql);
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }

    public static int deleteAvion(String placa) throws Exception {
        String sql = "delete from Avion where placa=" + placa + "";
        ResultSet rs = viajes.executeQuery(sql);
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }

    public static int deleteViaje(String numero_viaje) throws Exception {
        String sql = "delete from Viaje where numero_viaje=" + numero_viaje + "";
        ResultSet rs = viajes.executeQuery(sql);
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }

    public static int deleteVuelo(String numero_vuelo) throws Exception {
        String sql = "delete from Vuelo where numero_vuelo=" + numero_vuelo + "";
        ResultSet rs = viajes.executeQuery(sql);
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }
    //RESERVACIONES________________________________________________________
    //---Update estado asiento a ocupado
     public static int updateAsientoOcupado(Asiento asiento) throws Exception {
        //  return 1;

        String sql = "update Asiento "
                + "set estado=%b "
                + "where numero='%s'";
        sql = String.format(sql,
                asiento.isEstado(),
                asiento.getNumero());
        ResultSet rs = asientos.executeUpdateWithKeys(sql);
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }
      public static List<Asiento> selectSitsByNumber(String p) throws Exception {
        List<Asiento> sits;
        sits = new ArrayList();
        try {
            String sql = "select * from Asiento where numero = '"+p+"'";
            ResultSet rs = asientos.executeQuery(sql);
            while (rs.next()) {
                sits.add(toSits(rs));
            }
        } catch (SQLException ex) {
            throw new Exception("No existen asientos pare ese viaje");
        }
        return sits;
    }
      public static Asiento selectSitByNumber(String p) throws Exception {
        Asiento sit = new Asiento();
        try {
            String sql = "select * from Asiento where numero = '"+p+"'";
            ResultSet rs = asientos.executeQuery(sql);
            while (rs.next()) {
                sit =(toSits(rs));
            }
        } catch (SQLException ex) {
            throw new Exception("No existen asientos pare ese viaje");
        }
        return sit;
    }
      public static List<Reservacion> selectReservacionByUser(String usuario) throws Exception {
          //Usuario es el nombre de usuario
        List<Reservacion> re;
        re = new ArrayList();
        try {
            String sql = "select * from Reservacion where nombre_usuario = '"+usuario+"'";
            ResultSet rs = reservaciones.executeQuery(sql);
            while (rs.next()) {
                re.add(toReservacion(rs));
            }
        } catch (SQLException ex) {
            throw new Exception("No existen reservaciones pare este usuario");
        }
        return re;
    }
     public static Reservacion selectReservacion(String numero) throws Exception {
          //Usuario es el nombre de usuario
        Reservacion re = new Reservacion();
        try {
            String sql = "select * from Reservacion where codigo = '"+numero+"'";
            ResultSet rs = reservaciones.executeQuery(sql);
            while (rs.next()) {
                re = (toReservacion(rs));
            }
        } catch (SQLException ex) {
            throw new Exception("No existen reservaciones pare este usuario");
        }
        return re;
    }
//    public int getIDLastReserv()throws Exception{
//        String sql= "select MAX(codigo) FROM Reservacion";
//        ResultSet rs= reservaciones.executeQuery(sql);
//        if(rs.next()){
//            return rs.getInt("MAX(codigo)");
//        }
//        else{
//            throw new Exception("No hay facturas en espera");
//        }
//    }
//     public Reservacion getLastReser() throws Exception{
//        int lastId = this.getIDLastReserv();
//        return this.selectReservacion(lastId);
//        
//    }
    private static Reservacion toReservacion(ResultSet rs) throws Exception {
     try {
         Reservacion obj = new Reservacion();
         obj.setCodigo(rs.getString("codigo"));
         Usuario u = toUsers2(rs);
         obj.setNombreUsuario(u);
         int numViaje = rs.getInt("numero_viaje1");
         Viaje v = selectTravel(numViaje);
         obj.setViaje1(v);
         numViaje = rs.getInt("numero_viaje2");
         v = selectTravel(numViaje);
         obj.setViaje2(v);
         obj.setFecha_reserva(rs.getDate("fecha_reserva"));
         obj.setPrecioTotal(rs.getInt("precioTotal"));
         return obj;
     } catch (SQLException ex) {
         return null;
     }
    }
    private static Usuario toUsers2(ResultSet rs) throws Exception {
        try {
            Usuario obj = new Usuario();
            obj.setUsuario(rs.getString("nombre_usuario"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }
      public static int insertReservacionOneWay(Reservacion reservacion) throws Exception {
        //  return 1;

        String sql = "insert into Reservacion "
                + "(codigo,nombre_usuario, numero_viaje1,fecha_reserva,precioTotal) "
                + "values ('%s','%s',%s,'%s',%s)";
        sql = String.format(sql, reservacion.getCodigo(),
                reservacion.getNombreUsuario().getUsuario(),
                reservacion.getViaje1().getNumero_viaje(),
                new SimpleDateFormat("yyyy-MM-dd").format(reservacion.getFecha_reserva()),
                reservacion.getPrecioTotal());
        ResultSet rs = reservaciones.executeUpdateWithKeys(sql);
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }
       public static int insertReservacionTwoWays(Reservacion reservacion) throws Exception {
        //  return 1;

        String sql = "insert into Reservacion "
                + "(codigo,nombre_usuario, numero_viaje1,numero_viaje2,fecha_reserva,precioTotal) "
                + "values ('%s','%s',%s,%s,'%s',%s)";
        sql = String.format(sql,reservacion.getCodigo(),
                reservacion.getNombreUsuario().getUsuario(),
                reservacion.getViaje1().getNumero_viaje(),
                reservacion.getViaje2().getNumero_viaje(),
                new SimpleDateFormat("yyyy-MM-dd").format(reservacion.getFecha_reserva()),
                reservacion.getPrecioTotal());
        ResultSet rs = reservaciones.executeUpdateWithKeys(sql);
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            return 0;
        }
    }
    public static int insertIntoTiquete(Tiquete tiquete) throws Exception {
     //  return 1;

     String sql = "insert into Tiquete "
             + "(codigo_reservacion, codigo_asiento,nombre_pasajero,apellidosPasajero,pasaporte) "
             + "values ('%s','%s','%s','%s',%s)";
     sql = String.format(sql, tiquete.getCodigo_reservacion().getCodigo(),
             tiquete.getCodigo_asiento().getNumero(),
             tiquete.getNombre_pasajero(),
             tiquete.getApellidos_pasajero(),
             tiquete.getPasaporte_pasajero());
     ResultSet rs = tiquetes.executeUpdateWithKeys(sql);
     if (rs.next()) {
         return rs.getInt(1);
     } else {
         return 0;
     }
 }
    
    //Para parte de graficos-----------------------------------
     public static List<Tiquete> selectClientsByPlane(String placa) throws Exception {
          //Usuario es el nombre de usuario
        List<Tiquete> ticket;
        ticket = new ArrayList();
        try {
            String sql = "select T.nombre_pasajero from\n" +
                        "(select R.codigo from\n" +
                        "	(select V.numeroViaje from\n" +
                        "		(select placa from Avion where placa ='"+placa+"')A,\n" +
                        "		(select placa_avion , numeroViaje from Viaje)V\n" +
                        "		where A.placa = V.placa_avion)a1,\n" +
                        "	(select codigo,numero_viaje1, numero_viaje2 from Reservacion)R\n" +
                        "where R.numero_viaje1 = a1.numeroViaje Or R.numero_viaje2 = a1.numeroViaje)a2,\n" +
                        "(select codigo_reservacion , nombre_pasajero from Tiquete)T\n" +
                        "where T.codigo_reservacion = a2.codigo;";
            ResultSet rs = tiquetes.executeQuery(sql);
            while (rs.next()) {
                 ticket.add(toPasajeroTiquete(rs));
            }
        } catch (SQLException ex) {
            throw new Exception("Ningun usuario ha viajado en este avion");
        }
        return ticket;
    }
    private static Tiquete toPasajeroTiquete(ResultSet rs) throws Exception {
        try {
            Tiquete obj = new Tiquete();
            obj.setNombre_pasajero(rs.getString("nombre_pasajero"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }
    private static Tiquete toPasajeroTiquete2(ResultSet rs) throws Exception {
        try {
            Tiquete obj = new Tiquete();
            obj.setCodigo(rs.getInt("codigo"));
            Reservacion r = new Reservacion();
            r.setCodigo(rs.getString("codigo_reservacion"));
            r = selectReservacion(r.getCodigo());
            obj.setCodigo_reservacion(r);
            Asiento a = new Asiento();
            a.setNumero(rs.getString("codigo_asiento"));
            a = selectSitByNumber(a.getNumero());
            obj.setCodigo_asiento(a);
            obj.setNombre_pasajero(rs.getString("nombre_pasajero"));
            obj.setApellidos_pasajero(rs.getString("apellidosPasajero"));
            obj.setPasaporte_pasajero(rs.getInt("pasaporte"));
            
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }
    public static List<Tiquete> selectTiquete(String numero) throws Exception {
          //Usuario es el nombre de usuario
        List<Tiquete> t;
        t = new ArrayList();
        try {
            String sql = "select * from Tiquete where codigo_reservacion = '"+numero+"'";
            ResultSet rs = tiquetes.executeQuery(sql);
            while (rs.next()) {
                t.add(toPasajeroTiquete2(rs));
            }
        } catch (SQLException ex) {
            throw new Exception("No existen tiquetes");
        }
        return t;
    }
    //Cantidad facturado en los ultimos 12 meses----------------------------
      public static List<Reservacion> selectFacturaUltimos12() throws Exception {
          //Usuario es el nombre de usuario
        List<Reservacion> re;
        re = new ArrayList();
        try {
            String sql = "select sum(precioTotal)"
                    + " from Reservacion "
                    + "where fecha_reserva >= DATE_SUB(NOW(),INTERVAL 1 YEAR);";
            ResultSet rs = reservaciones.executeQuery(sql);
            while (rs.next()) {
                 re.add(toReservaTotal(rs));
            }
        } catch (SQLException ex) {
            throw new Exception("Ningun usuario ha viajado en este avion");
        }
        return re;
    }
      //Cantidad facturado en el  año actual----------------------------
      public static List<Reservacion> selectReCurrentYear() throws Exception {
          //Usuario es el nombre de usuario
        List<Reservacion> re;
        re = new ArrayList();
        try {
            String sql = "select sum(precioTotal) "
                    + "from Reservacion"
                    + " where year(fecha_reserva) = year(curdate());";
            ResultSet rs = reservaciones.executeQuery(sql);
            while (rs.next()) {
                 re.add(toReservaTotal(rs));
            }
        } catch (SQLException ex) {
            throw new Exception("Ningun usuario ha viajado en este avion");
        }
        return re;
    }
    private static Reservacion toReservaTotal(ResultSet rs) throws Exception {
        try {
            Reservacion obj = new Reservacion();
            obj.setPrecioTotal(rs.getInt("sum(precioTotal)"));
            return obj;
        } catch (SQLException ex) {
            return null;
        }
    }
}


