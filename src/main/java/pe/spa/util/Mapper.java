package pe.spa.util;

import java.util.ArrayList;
import java.util.Collection;

import pe.spa.entity.Promocion;
import pe.spa.mapper.PromocionMapper;

public class Mapper {
	
	public static Collection<PromocionMapper> toPromocionListarEspecifico(Collection<Promocion> promociones) {

		Collection<PromocionMapper> collection = new ArrayList<>();

		for (Promocion promocion : promociones) {
			PromocionMapper mapper = new PromocionMapper(promocion);
			collection.add(mapper);
		}

		return collection;
	}

}
