package com.pablodomingos.classes.nfse.builders.interfaces;

import com.pablodomingos.classes.nfse.enums.IssRetido;

public interface ValoresBuilder {

  public Double getValorServicos();

  public Double getValorDeducoes();

  public Double getValorPis();

  public Double getValorCofins();

  public Double getValorInss();

  public Double getValorIr();
  
  public Double getValorCsll();

  public IssRetido getIssRetido();

  public Double getOutrasRetencoes();

  public Double getAliquota();

  public Double getDescontoIncondicionado();

  public Double getDescontoCondicionado();

}

