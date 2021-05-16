package controllers;

import controllers.MenuController;
import controllers.MovimientoDeBarajaADescarte;
import controllers.MovimientoDeDescarteAEscalera;
import controllers.MovimientoDeDescarteAFundacion;
import controllers.MovimientoDeEscaleraAEscalera;
import controllers.MovimientoDeEscaleraAFundacion;
import controllers.MovimientoDeFundacionAEscalera;
import controllers.MovimientoDescarteABaraja;

public abstract interface ControllerVisitor {
	public abstract int visitMenu(MenuController paramMenuController);

	public abstract void visitMovimientoDeBarajaADescarte(
			MovimientoDeBarajaADescarte paramMovimientoDeBarajaADescarte);

	public abstract void visitMovimientoDescarteABaraja(
			MovimientoDescarteABaraja paramMovimientoDescarteABaraja);

	public abstract void visitMovimientoDeDescarteAFundacion(
			MovimientoDeDescarteAFundacion paramMovimientoDeDescarteAFundacion);

	public abstract void visitMovimientoDeDescarteAEscalera(
			MovimientoDeDescarteAEscalera paramMovimientoDeDescarteAEscalera);

	public abstract void visitMovimientoDeEscaleraAFundacion(
			MovimientoDeEscaleraAFundacion paramMovimientoDeEscaleraAFundacion);

	public abstract void visitMovimientoDeEscaleraAEscalera(
			MovimientoDeEscaleraAEscalera paramMovimientoDeEscaleraAEscalera);

	public abstract void visitMovimientoDeFundacionAEscalera(
			MovimientoDeFundacionAEscalera paramMovimientoDeFundacionAEscalera);
}
