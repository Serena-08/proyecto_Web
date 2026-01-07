<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> .
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
   <title>Hello Servlet</title>
</head>
<body>
  <div class="container-fluid">
      <div class="row">
          <div class="col-md-2 d-none d-md-block sidebar p-3">
              <a href="index.html" class="text-decoration-none text-white">
                  <h4 class="mb-4 text-center"><i class="bi bi-chat-quote-fill"></i> SeedNow</h4>
              </a>

              <ul class="nav flex-column">
                  <li class="nav-item">
                      <a class="nav-link active" href="#"><i class="bi bi-plus-circle me-2"></i> Nuevo Mensaje</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="#"><i class="bi bi-calendar-check me-2"></i> Calendario</a>
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="mensajes.html"><i class="bi bi-clock-history me-2"></i> Mis Mensajes</a>
                  </li>

                  <hr class="text-white-50"> <li class="nav-item">
                      <a class="nav-link" href="index.html"><i class="bi bi-box-arrow-left me-2"></i> Salir / Inicio</a>
                  </li>
              </ul>
          </div>

          <div class="col-md-10 p-4">
              <h2 class="mb-4 fw-bold text-dark">Programar Nuevo Envío</h2>

              <div class="row">
                  <div class="col-lg-7 mb-4">
                      <div class="card shadow-sm border-0">
                          <div class="card-body p-4">
                              <form>
                                  <label class="form-label fw-bold">1. Selecciona la Plataforma</label>
                                  <div class="row mb-3">
                                      <div class="col-4">
                                          <input type="radio" name="platform" id="check-wa" class="platform-checkbox" checked>
                                          <label for="check-wa" class="platform-label"><i class="bi bi-whatsapp"></i> WhatsApp</label>
                                      </div>
                                      <div class="col-4">
                                          <input type="radio" name="platform" id="check-ig" class="platform-checkbox">
                                          <label for="check-ig" class="platform-label"><i class="bi bi-instagram"></i> Instagram</label>
                                      </div>
                                      <div class="col-4">
                                          <input type="radio" name="platform" id="check-li" class="platform-checkbox">
                                          <label for="check-li" class="platform-label"><i class="bi bi-linkedin"></i> LinkedIn</label>
                                      </div>
                                  </div>

                                  <div class="mb-3">
                                      <label for="messageContent" class="form-label fw-bold">2. Contenido</label>
                                      <textarea class="form-control bg-light" id="messageContent" rows="5" placeholder="Escribe aquí..."></textarea>
                                  </div>

                                  <div class="row mb-4">
                                      <div class="col-md-6">
                                          <label class="form-label fw-bold">3. Fecha</label>
                                          <input type="date" class="form-control">
                                      </div>
                                      <div class="col-md-6">
                                          <label class="form-label fw-bold">4. Hora</label>
                                          <input type="time" class="form-control">
                                      </div>
                                  </div>

                                  <div class="d-grid">
                                      <button type="button" class="btn btn-schedule rounded-pill shadow-sm">
                                          <i class="bi bi-send-check me-2"></i> Programar Mensaje
                                      </button>
                                  </div>
                              </form>
                          </div>
                      </div>
                  </div>

                  <div class="col-lg-5">
                      <h5 class="mb-3 text-secondary">Cola de Salida</h5>
                      <div class="card mb-3 shadow-sm border-0 scheduled-card border-wa">
                          <div class="card-body">
                              <div class="d-flex justify-content-between align-items-center mb-2">
                                  <span class="badge bg-success"><i class="bi bi-whatsapp"></i> WhatsApp</span>
                                  <small class="text-muted">Hoy, 18:00</small>
                              </div>
                              <p class="card-text text-truncate">Recordatorio de reunión...</p>
                          </div>
                      </div>
                       <div class="card mb-3 shadow-sm border-0 scheduled-card border-ig">
                          <div class="card-body">
                              <div class="d-flex justify-content-between align-items-center mb-2">
                                  <span class="badge" style="background: #C13584;"><i class="bi bi-instagram"></i> Instagram</span>
                                  <small class="text-muted">Mañana, 10:00</small>
                              </div>
                              <p class="card-text text-truncate">Nuevo post de producto...</p>
                          </div>
                      </div>
                  </div>
              </div>
          </div>
      </div>
  </div>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
  </body>
</body>
</html>
