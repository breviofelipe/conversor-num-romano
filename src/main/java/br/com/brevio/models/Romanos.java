package br.com.brevio.models;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum Romanos {

	I(1), IV(4), V(5), IX(9), X(10), XL(40), L(50), XC(90), C(100), CD(400), D(500), CM(900), M(1000);

	private int valor;
	private static int value;

	Romanos(int valor) {
		this.valor = valor;
	}

	public int getValor() {
		return valor;
	}

	public static String getValorRomano(int numero) throws IOException {

		if (numero > 1 && numero <= 3999) {
			value = numero;
			StringBuilder retorno = new StringBuilder();
			List<Romanos> list = Arrays.asList(Romanos.values());
			Collections.reverse(list);
			list.stream().forEach(romano -> {

				value = loop(value, romano, retorno);

			});

			return retorno.toString();
		}
		throw new IOException("Valor invalido. Max 3999");
	}

	public static int getValor(String valorRomano) {
		
		List<String> list = Arrays.asList(valorRomano.toUpperCase().split(""));
		Collections.reverse(list);

		int i = 0;
		boolean b = false;
		int retorno = 0;

		do {
			String r = list.get(i);
			if (!b) {
				retorno += Romanos.valueOf(r).getValor();
				if (list.size() > i) {
					if (list.size() != i + 1
							&& Romanos.valueOf(list.get(i)).getValor() > Romanos.valueOf(list.get(i + 1)).getValor()) {
						b = true;
					}
				}
			} else {
				retorno -= Romanos.valueOf(r).getValor();
				b = false;
			}
			i++;
		} while (i < list.size());

		return retorno;
	}

	private static int loop(int valor, Romanos valorRomano, StringBuilder retorno) {

		while (valor >= valorRomano.getValor()) {
			retorno.append(valorRomano.name());
			valor -= valorRomano.getValor();
		}
		return valor;
	}
}
