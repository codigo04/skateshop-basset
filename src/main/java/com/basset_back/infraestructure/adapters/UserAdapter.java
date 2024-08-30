package com.basset_back.infraestructure.adapters;

import com.basset_back.dominio.aggretes.Enum.Roles;
import com.basset_back.dominio.aggretes.dto.User;
import com.basset_back.dominio.aggretes.Enum.Documento;
import com.basset_back.dominio.ports.out.UserServOut;
import com.basset_back.infraestructure.dao.RolDao;
import com.basset_back.infraestructure.dao.UsuarioDao;
import com.basset_back.infraestructure.entity.Rol;
import com.basset_back.infraestructure.entity.Usuario;
import com.basset_back.infraestructure.mapper.RoleMapper;
import com.basset_back.infraestructure.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserAdapter implements UserServOut {

    @Autowired
    UsuarioDao usuarioDao;

    @Autowired
    RolDao rolDao;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    UserMapper userMapper;


    @Override
    public Optional<User> createUser(User user) {
        return Optional.of(createAndSaveUser(user, Roles.USER));
    }

    @Override
    public Optional<User> createAmin(User user) {
        return Optional.of(createAndSaveUser(user, Roles.ADMIN));
    }




    @Override
    public void deleteUser(String dniUser) {
        Optional<User> user = searchUserByNumeroDoc(dniUser);

        if (user.isPresent()) {
            usuarioDao.deleteByNumeroDoc(dniUser);
        }
    }

    @Override
    public Optional<User> updateUser(User user) {
        Optional<Usuario> usuario = usuarioDao.findByNumeroDoc(user.getNumberDoc());


        if (usuario.isPresent()) {
            Usuario usuarioNew = usuario.get();
            usuarioNew.setNombre(user.getName());
            usuarioNew.setApellido(user.getLastname());
            usuarioDao.save(usuarioNew);

            return Optional.of(userMapper.toUser(usuarioNew));
        }


        return Optional.empty();
    }

    @Override
    public Optional<User> searchUserByNombre(String nombre) {
        Optional<Usuario> usuario = usuarioDao.findByNombre(nombre);
        return usuario.map(us -> userMapper.toUser(us));
    }

    @Override
    public Optional<User> searchUserByNumeroDoc(String documento) {
        Optional<Usuario> usuario = usuarioDao.findByNumeroDoc(documento);

        return usuario.map(us -> userMapper.toUser(us));
    }

    private User createAndSaveUser(User user, Roles role) {
        Usuario usuario = new Usuario();
        usuario.setNombre(user.getName());
        usuario.setApellido(user.getLastname());
        usuario.setGmail(user.getGmail());
        usuario.setContrasena(user.getPassword());
        usuario.setTipoDoc(Documento.DNI.name());
        usuario.setNumeroDoc(user.getNumberDoc());

        Set<Rol> assignedRoles = new HashSet<>();
        Rol rol = rolDao.findByNombreRol(role.name())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));
        assignedRoles.add(rol);

        usuario.setRolesUsuario(assignedRoles);

        return userMapper.toUser(usuarioDao.save(usuario));
    }
}
